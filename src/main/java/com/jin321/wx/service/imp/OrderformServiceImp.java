package com.jin321.wx.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jin321.pl.dao.*;
import com.jin321.pl.model.*;
import com.jin321.pl.utils.JWTUtil;
import com.jin321.pl.utils.OrderState;
import com.jin321.pl.utils.PayCommonUtil;
import com.jin321.wx.dao.OrderformDetailMapper;
import com.jin321.wx.model.LoginEntity;
import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.model.OrderformProductDetail;
import com.jin321.wx.model.OrderformProductPo;
import com.jin321.wx.service.OrderformService;
import com.jin321.wx.utils.OidUtil;
import com.jin321.wx.utils.WXUtil;
import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;


/**
 * @Author hao
 * @Date 2017/10/11 17:41
 * @Description :订单
 */
@Service("orderformService")
@Transactional(rollbackFor = Exception.class)
public class OrderformServiceImp implements OrderformService {
    private static final Log log = LogFactory.getLog(OrderformServiceImp.class);
    @Autowired
    OrderformMapper orderformMapper;
    @Autowired
    OrderformproductMapper orderformproductMapper;
    @Autowired
    OrderformDetailMapper orderformDetailMapper;
    @Autowired
    ProductsizeMapper productsizeMapper;
    @Autowired
    ExpressageMapper expressageMapper;
    @Autowired
    DealerbuyformMapper dealerbuyformMapper;
    /**
     * 添加订单
     *
     * @param orderformDetails
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map insertOrder(OrderformDetail[] orderformDetails, HttpServletRequest request) throws Exception {
        //支付单
        Dealerbuyform dealerbuyform = new Dealerbuyform();
        long dbfid = OidUtil.newOid();
        dealerbuyform.setDbfid(dbfid);
        dealerbuyform.setBuyformstate(OrderState.PLACE_ORDER_NOTPAY);
        //支付单总价
        BigDecimal peice = new BigDecimal(0);
        for (OrderformDetail orderformDetail : orderformDetails) {


            //当前订单订单号
            long oid = OidUtil.newOid();
            orderformDetail.setOid(oid);
            orderformDetail.setOdate(new Date());
            orderformDetail.setOstate(OrderState.PLACE_ORDER_NOTPAY);
            orderformDetail.setDbfid(dbfid);
            //插入订单信息
            int insert = orderformDetailMapper.insert(orderformDetail);
            if (!(insert > 0)) {
                log.warn("订单插入失败");
                throw new Exception("订单插入失败");
            }

            //插入订单商品信息
            List<Orderformproduct> orderformproducts = orderformDetail.getOrderformproducts();
            for (Orderformproduct orderformproduct : orderformproducts) {
                orderformproduct.setOid(oid);
                Productsize productsize = productsizeMapper.selectByPrimaryKey(orderformproduct.getSid());
                if (productsize == null) {
                    log.warn("未知商品型号" + orderformproduct.getSid());
                    throw new Exception("未知商品型号");
                }
                //获得下单时商品价格
                BigDecimal pssellprice = productsize.getPssellprice();
                //累加订单信息
                peice = peice.add(pssellprice.multiply(BigDecimal.valueOf(orderformproduct.getPamount())));
                orderformproduct.setPbuyprice(pssellprice);
                int insert1 = orderformproductMapper.insert(orderformproduct);
                if (!(insert1 > 0)) {
                    log.warn("订单插入失败");
                    throw new Exception("订单插入失败");
                }
            }
        }
        //设置支付单支付总价
        dealerbuyform.setTotalmoney(peice);
        //保存支付单信息
        dealerbuyformMapper.insert(dealerbuyform);

        //从session中获得openid
        LoginEntity loginEntity = JWTUtil.parseJWTToBean(orderformDetails[0].getSession(), new LoginEntity());
        String openid = loginEntity.getOpenid();

        //调用微信支付统一下单api
        log.info("调用微信统一下单API，下单信息：支付单单号：" + dbfid + "价格：" + peice + "openid:" + openid + "地址:" + request.getRemoteAddr());
        Map<String, String> map = WXUtil.weixinPrePay(String.valueOf(dbfid), peice, "晋321——商品支付", openid, request);

        if ("SUCCESS".equals(map.get("return_code"))) {
            if ("SUCCESS".equals(map.get("result_code"))) {
                SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();
                parameterMap.put("package", "prepay_id=" + map.get("prepay_id"));
                parameterMap.put("appId", WXUtil.APPID);
                parameterMap.put("nonceStr", PayCommonUtil.getRandomString(32));
                parameterMap.put("timeStamp", System.currentTimeMillis());
                parameterMap.put("signType", "MD5");
                String sign = PayCommonUtil.createSign(parameterMap);
                parameterMap.put("paySign", sign);
                return parameterMap;
            } else {
                log.warn("统一下单API业务结果失败，错误代码-》" + map.get("err_code") + "错误代码描述-》" + map.get("err_code_des"));
            }
        } else {
            log.warn("统一下单API调用失败,返回信息-》" + map.get("return_msg"));
        }


        return map;
    }

    /**
     * 退单
     *
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean chargebackOrder(long oid, String message) throws Exception {

        //查询订单
        Orderform orderform = orderformMapper.selectByPrimaryKey(oid);
        if (orderform == null) {
//            throw new Exception("订单号错误");
            log.warn("退单，订单号错误" + oid);
            return false;
        }
        //更新订单信息
        orderform.setOstate(OrderState.CANCELLATION_OF_ORDER);
        orderform.setOrepaytime(new Date());
        int i = orderformMapper.updateByPrimaryKeySelective(orderform);
        if (i < 1) {
            log.warn("退单，数据库错误" + oid);
            return false;
        }
        //通知后台
        String url = "https://www.jin321.cn/ms/getpaybackevent";
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
        log.info("管理系统服务器返回：" + string);
        Map<String, String> params = JSONObject.parseObject(string, new TypeReference<Map<String, String>>() {
        });
        String code = params.get("code");
        if ("0".equals(code)) {
            log.warn("管理系统错误");
            return false;
        }
        return true;
    }


    /**
     * 查询订单
     *
     * @param uid  用户id
     * @param code 条件码
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<OrderformProductDetail> selectOrderByuid(String uid, int code) throws Exception {
        List<OrderformProductDetail> orderformProductDetails = null;
        if (code == 0) {
            orderformProductDetails = orderformDetailMapper.selectOrderformByuid(uid);
        }
        if (code == 1) {
            orderformProductDetails = orderformDetailMapper.selectNOTPAYOrderformByuid(uid);
        }
        if (code == 2) {
            orderformProductDetails = orderformDetailMapper.selectNOTShipmentsOrderformByuid(uid);
        }
        if (code == 3) {
            orderformProductDetails = orderformDetailMapper.selectNOTRECEIVEOrderformByuid(uid);
        }
        if (orderformProductDetails != null) {
            orderformProductDetails = totalPrice(orderformProductDetails);
        }
        return orderformProductDetails;
    }

    /**
     * 通过oid查询订单信息
     *
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public OrderformProductDetail selectOrderByoid(String oid) throws Exception {
        OrderformProductDetail orderformProductDetail = orderformDetailMapper.selectOrderformByoid(Long.valueOf(oid));
        BigDecimal peice = new BigDecimal(0);
        //获取订单内商品详情
        List<OrderformProductPo> orderformProductPos = orderformProductDetail.getOrderformProductPos();
        for (OrderformProductPo orderformProductPo : orderformProductPos) {
            BigDecimal pbuyprice = orderformProductPo.getPbuyprice();
            peice = peice.add(pbuyprice.multiply(BigDecimal.valueOf(orderformProductPo.getPamount())));
        }
        orderformProductDetail.setTotalprice(peice);

        return orderformProductDetail;

    }

    @Override
    public String selectExpressageByOid(String oid) throws Exception {
        Orderform orderform = orderformMapper.selectByPrimaryKey(Long.valueOf(oid));
        if (orderform == null) {
            log.info("查询订单物流信息 ， 订单不存在" + oid);
            return "{\"code\":\"0\",\"message\":\"订单不存在\"}";
        }
        int ostate = orderform.getOstate();
        if (ostate == OrderState.PLACE_ORDER_NOTPAY) {
            log.info("查询订单物流信息 ， 用户未付款" + oid);
            return "{\"code\":\"0\",\"message\":\"用户未付款\"}";
        }
        if (ostate == OrderState.PLACE_ORDER_PAY) {
            log.info("查询订单物流信息 ， 商家未发货" + oid);
            return "{\"code\":\"0\",\"message\":\"商家未发货\"}";
        }
        if (ostate == OrderState.USER_DELETION_ORDER) {
            log.info("查询订单物流信息 ， 用户已删除订单" + oid);
            return "{\"code\":\"0\",\"message\":\"用户已删除订单\"}";
        }
        String osendmethod = orderform.getOsendmethod();
        String osendnumber = orderform.getOsendnumber();
        ExpressageExample expressageExample = new ExpressageExample();
        ExpressageExample.Criteria criteria = expressageExample.createCriteria();
        criteria.andComEqualTo(osendmethod);
        List<Expressage> expressages = expressageMapper.selectByExample(expressageExample);
        if (expressages == null || expressages.size() < 1) {
            log.info("查询订单物流信息 ， 不支持的商家" + oid);
            return "{\"code\":\"0\",\"message\":\"不支持的商家\"}";
        }

        Expressage expressage = expressages.get(0);
        String no = expressage.getNo();


        //请求聚合数据
        String url = "http://v.juhe.cn/exp/index";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("com", no)
                .add("key", WXUtil.JUHE_key)
                .add("no", osendnumber)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        log.info("聚合服务器返回：" + string);
        return string;
    }

    /**
     * 支付未支付订单
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> payOrder(Long oid, String session, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        OrderformProductDetail orderformProductDetail = orderformDetailMapper.selectOrderformByoid(oid);
        if (orderformProductDetail == null) {
            map.put("code", "0");
            map.put("message", "订单号不存在");
            log.info("支付未支付订单，订单号不存在：" + oid);
            return map;
        }
        if (orderformProductDetail.getOstate() != OrderState.PLACE_ORDER_NOTPAY) {
            map.put("code", "0");
            map.put("message", "订单已支付或已删除");
            log.info("支付未支付订单，订单订单已支付或已删除：" + oid);
            return map;
        }
        //订单总价
        BigDecimal peice = new BigDecimal(0);
        //获取订单内商品详情
        List<OrderformProductPo> orderformProductPos = orderformProductDetail.getOrderformProductPos();
        for (OrderformProductPo orderformProductPo : orderformProductPos) {
            BigDecimal pbuyprice = orderformProductPo.getPbuyprice();
            peice = peice.add(pbuyprice.multiply(BigDecimal.valueOf(orderformProductPo.getPamount())));
        }
        //生成新的支付单
        Dealerbuyform dealerbuyform = new Dealerbuyform();
        long dbfid = OidUtil.newOid();
        dealerbuyform.setDbfid(dbfid);
        dealerbuyform.setBuyformstate(OrderState.PLACE_ORDER_NOTPAY);
        dealerbuyform.setTotalmoney(peice);
        //保存新支付单信息
        dealerbuyformMapper.insert(dealerbuyform);
        //删除下单时默认生成的支付单
//        dealerbuyformMapper.deleteByPrimaryKey(orderformProductDetail.getDbfid());
        //替换为新的支付单信息
        orderformDetailMapper.updateDbfid(oid, dbfid);


        //从session中获得openid
        LoginEntity loginEntity = JWTUtil.parseJWTToBean(session, new LoginEntity());
        String openid = loginEntity.getOpenid();
//        String openid = "";

        //调用微信支付统一下单api
        log.info("调用微信统一下单API，下单信息：订单号：" + oid + "价格：" + peice + "openid:" + openid + "地址:" + request.getRemoteAddr());
        Map<String, String> map1 = WXUtil.weixinPrePay(String.valueOf(oid), peice, "晋321——商品支付", openid, request);

        if ("SUCCESS".equals(map1.get("return_code"))) {
            if ("SUCCESS".equals(map1.get("result_code"))) {
                SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();
                parameterMap.put("package", "prepay_id=" + map.get("prepay_id"));
                parameterMap.put("appId", WXUtil.APPID);
                parameterMap.put("nonceStr", PayCommonUtil.getRandomString(32));
                parameterMap.put("timeStamp", System.currentTimeMillis());
                parameterMap.put("signType", "MD5");
                String sign = PayCommonUtil.createSign(parameterMap);
                parameterMap.put("paySign", sign);
                return parameterMap;
            } else {
                log.warn("统一下单API业务结果失败，错误代码-》" + map.get("err_code") + "错误代码描述-》" + map.get("err_code_des"));
            }
        } else {
            log.warn("统一下单API调用失败,返回信息-》" + map.get("return_msg"));
        }

        map.put("code", "0");
        map.put("message", "统一下单API调用失败");
        return map;
    }

    /**
     * 删除订单
     *
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> deleteOrder(Long oid) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Orderform orderform = orderformMapper.selectByPrimaryKey(oid);
        if (orderform == null) {
            map.put("code", "0");
            map.put("message", "订单号不存在");
            log.info("删除订单，订单号不存在：" + oid);
            return map;
        }
        orderform.setOstate(OrderState.USER_DELETION_ORDER);
        orderformMapper.updateByPrimaryKey(orderform);
        map.put("code", "1");
        map.put("message", "删除成功");
        return map;
    }

    /**
     * 计算每张订单的总价，设置到OrderformProductDetail对象中
     *
     * @param list
     * @return
     */
    private List<OrderformProductDetail> totalPrice(List<OrderformProductDetail> list) {
        for (OrderformProductDetail orderformProductDetail : list) {
            BigDecimal peice = new BigDecimal(0);
            //获取订单内商品详情
            List<OrderformProductPo> orderformProductPos = orderformProductDetail.getOrderformProductPos();
            for (OrderformProductPo orderformProductPo : orderformProductPos) {
                BigDecimal pbuyprice = orderformProductPo.getPbuyprice();
                peice = peice.add(pbuyprice.multiply(BigDecimal.valueOf(orderformProductPo.getPamount())));
            }
            orderformProductDetail.setTotalprice(peice);
        }
        return list;
    }

}
