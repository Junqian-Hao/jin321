package com.jin321.wx.controller;

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

    @RequestMapping("/insertOrder")
    @ResponseBody
    public Map insertOrder(@RequestBody OrderformDetail orderformDetail, HttpServletRequest request) throws Exception {
        log.info("下单->"+orderformDetail);
        Map map = orderformService.insertOrder(orderformDetail, request);
        return map;
    }

    @RequestMapping("/selectOrderformByuid")
    @ResponseBody
    public List<OrderformProductDetail> selectOrderformByuid(@RequestBody OrderformDetail orderformDetail) throws Exception {
        log.info("查询订单->"+orderformDetail.getUid());
        List<OrderformProductDetail> orderformProductDetails = orderformService.selectOrderByuid(orderformDetail.getUid());
        return orderformProductDetails;
    }

}
