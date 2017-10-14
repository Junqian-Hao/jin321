package com.jin321.wx.service.imp;

import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.utils.OrderState;
import com.jin321.wx.dao.OrderformDetailMapper;
import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.service.OrderformService;
import com.jin321.wx.utils.OidUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
            throw new Exception("订单插入失败");
        }
        List<Orderformproduct> orderformproducts = orderformDetail.getOrderformproducts();
        for (Orderformproduct orderformproduct : orderformproducts) {
            orderformproduct.setOid(oid);
            Productsize productsize = productsizeMapper.selectByPrimaryKey(orderformproduct.getSid());
            if (productsize == null) {
                throw new Exception("未知商品型号");
            }
            BigDecimal pssellprice = productsize.getPssellprice();
            orderformproduct.setPbuyprice(pssellprice);
            int insert1 = orderformproductMapper.insert(orderformproduct);
            if (!(insert1 > 0)) {
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
    public boolean chargebackOrder(long oid) throws Exception {

        //查询订单
        Orderform orderform = orderformMapper.selectByPrimaryKey(oid);
        if (orderform == null) {
//            throw new Exception("订单号错误");
            return false;
        }
        //更新订单信息
        orderform.setOstate(OrderState.CANCELLATION_OF_ORDER);
        orderform.setOrepaytime(new Date());
        int i = orderformMapper.updateByPrimaryKeySelective(orderform);
        if (i < 1) {
            return false;
        }
        //通知后台

        return true;
    }


}
