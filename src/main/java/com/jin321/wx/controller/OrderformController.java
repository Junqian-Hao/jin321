package com.jin321.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.model.OrderformProductDetail;
import com.jin321.wx.service.OrderformService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/11 18:23
 * @Description :订单控制器
 */
@Controller
@RequestMapping("/wx")
public class OrderformController {
    private static final Log log = LogFactory.getLog(OrderformController.class);
    @Autowired
    OrderformService orderformService;

    /**
     * 下单
     * @param orderformDetail
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertOrder")
    @ResponseBody
    public Map insertOrder(@RequestBody OrderformDetail[] orderformDetail, HttpServletRequest request) throws Exception {
        log.info("下单->"+orderformDetail);
        Map map = orderformService.insertOrder(orderformDetail, request);
        return map;
    }

    /**
     * 查询订单信息
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectOrderformByuid")
    @ResponseBody
    public List<OrderformProductDetail> selectOrderformByuid(@RequestBody Map<String , String> rq) throws Exception {
        String uid = rq.get("uid");
        String code = rq.get("code");
        log.info("查询订单->uid:"+uid+"code:"+code);
        List<OrderformProductDetail> orderformProductDetails = orderformService.selectOrderByuid(uid, Integer.parseInt(code));
        return orderformProductDetails;
    }

    /**
     * 支付未支付订单
     * @param rq
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("payOrder")
    @ResponseBody
    public Map<String, Object> payOrder(@RequestBody Map<String, String> rq,HttpServletRequest request) throws Exception {
        String oid = rq.get("oid");
        String session = rq.get("session");
        log.info("支付未支付订单-》订单号：" + oid + "session:" + session);
        Map<String, Object> map = orderformService.payOrder(Long.valueOf(oid), session, request);
        return map;
    }

    /**
     * 删除订单
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteOrder")
    @ResponseBody
    public Map<String, String> deleteOrder(@RequestBody Map<String, String> rq) throws Exception {
        String oid = rq.get("oid");
        log.info("删除订单-》订单号：" + oid );
        Map<String, String> map = orderformService.deleteOrder(Long.valueOf(oid));
        return map;
    }

    /**
     * 通过订单号查询订单
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("selectOrderByoid")
    @ResponseBody
    public OrderformProductDetail selectOrderByoid(@RequestBody Map<String, String> rq) throws Exception {
        String oid = rq.get("oid");
        log.info("通过oid查询订单->" + oid);
        return orderformService.selectOrderByoid(oid);
    }

    /**
     * 通过订单号查询物流信息
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("selectExpressageByOid")
    @ResponseBody
    public Map<String, String> selectExpressageByOid(@RequestBody Map<String, String> rq) throws Exception {
        String oid = rq.get("oid");
        log.info("通过订单号查询物流信息" + oid);
        String s = orderformService.selectExpressageByOid(oid);
        Map<String, String> params = JSONObject.parseObject(s, new TypeReference<Map<String, String>>(){});
        return params;
    }
}
