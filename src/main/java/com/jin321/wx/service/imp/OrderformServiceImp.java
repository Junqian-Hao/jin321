package com.jin321.wx.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.utils.OrderState;
import com.jin321.wx.dao.OrderformDetailMapper;
import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.model.OrderformProductDetail;
import com.jin321.wx.service.OrderformService;
import com.jin321.wx.utils.OidUtil;
import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/11 17:41
 * @Description :订单
 */
@Service("orderformService")
public class OrderformServiceImp implements OrderformService{
    private static final Log log = LogFactory.getLog(OrderformServiceImp.class);
    @Autowired
    OrderformMapper orderformMapper;
    @Autowired
    OrderformproductMapper orderformproductMapper;
    @Autowired
    OrderformDetailMapper orderformDetailMapper;
    @Autowired
    ProductsizeMapper productsizeMapper;

    /**
     * 添加订单
     * @param orderformDetail
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrder(OrderformDetail orderformDetail) throws Exception {
        long oid = OidUtil.newOid();
        orderformDetail.setOid(oid);
        orderformDetail.setOdate(new Date());
        orderformDetail.setOstate(OrderState.PLACE_ORDER_NOTPAY);
        int insert = orderformDetailMapper.insert(orderformDetail);
        if (!(insert > 0)) {
            log.warn("订单插入失败");
            throw new Exception("订单插入失败");
        }
        List<Orderformproduct> orderformproducts = orderformDetail.getOrderformproducts();
        for (Orderformproduct orderformproduct : orderformproducts) {
            orderformproduct.setOid(oid);
            Productsize productsize = productsizeMapper.selectByPrimaryKey(orderformproduct.getSid());
            if (productsize == null) {
                log.warn("未知商品型号"+orderformproduct.getSid());
                throw new Exception("未知商品型号");
            }
            BigDecimal pssellprice = productsize.getPssellprice();
            orderformproduct.setPbuyprice(pssellprice);
            int insert1 = orderformproductMapper.insert(orderformproduct);
            if (!(insert1 > 0)) {
                log.warn("订单插入失败");
                throw new Exception("订单插入失败");
            }
        }
        return true;
    }

    /**
     * 退单
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public boolean chargebackOrder(long oid,String message) throws Exception {

        //查询订单
        Orderform orderform = orderformMapper.selectByPrimaryKey(oid);
        if (orderform == null) {
//            throw new Exception("订单号错误");
            log.warn("退单，订单号错误"+oid);
            return false;
        }
        //更新订单信息
        orderform.setOstate(OrderState.CANCELLATION_OF_ORDER);
        orderform.setOrepaytime(new Date());
        int i = orderformMapper.updateByPrimaryKeySelective(orderform);
        if (i < 1) {
            log.warn("退单，数据库错误"+oid);
            return false;
        }
        //通知后台
        String url = "https://www.haojunqian.cn/ms/getpaybackevent";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("oid", String.valueOf(oid))
                .add("msg", message)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        log.info("管理系统服务器返回："+string);
        Map<String, String> params = JSONObject.parseObject(string, new TypeReference<Map<String, String>>(){});
        String code = params.get("code");
        if ("0".equals(code)) {
            log.warn("管理系统错误");
            return false;
        }
        return true;
    }


    @Override
    public List<OrderformProductDetail> selectOrderByuid(String uid) throws Exception {
        List<OrderformProductDetail> orderformProductDetails = orderformDetailMapper.selectOrderformByuid(uid);
        return orderformProductDetails;
    }


}
