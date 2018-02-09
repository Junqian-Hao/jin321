package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.Service.PayBackEventService;
import com.jin321.ms.model.PayReturnMessage;
import com.jin321.ms.model.RecieveMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/12/21.
 *
 * @Description ://在支付单表中保存支付时间。（未实现
 */
@Controller
@RequestMapping("/ms")
public class RecievePayMessageController {
    private static final Log log = LogFactory.getLog(RecievePayMessageController.class);
    @Autowired
    private OrderFormService orderFormService;
    private PayReturnMessage payReturnMessage;
    private int sign;
    private int sign2;

    @RequestMapping("/recievePayMessage")
    @ResponseBody
    public PayReturnMessage getReturnMessage(@RequestBody RecieveMessage recieveMessage) throws Exception {
        payReturnMessage = new PayReturnMessage();
        log.info("微信调起接口，从微信获取到的信息为:" + recieveMessage);
        if (recieveMessage.getResult_code().equals("SUCCESS")) {
            ///待修改
          /* sign = orderFormService.changeOrderFormStatue(1, Long.parseLong(recieveMessage.getOut_trade_no()), new Date());*/
            sign2 = orderFormService.decreaseOrderProductNum(Long.parseLong(recieveMessage.getOut_trade_no()));
            if (sign == 1) {
                if (sign2 == 0) {
                    payReturnMessage.setReturn_code("FAIL");
                    payReturnMessage.setReturn_msg("商品数量更改失败");
                } else {
                    payReturnMessage.setReturn_code("SUCCESS");
                    payReturnMessage.setReturn_msg("支付成功");
                }
            } else if (sign == 0) {
                payReturnMessage.setReturn_msg("FAIL");
                payReturnMessage.setReturn_msg("支付状态修改失败");
            }
        } else {
            payReturnMessage.setReturn_code("FAIL");
            payReturnMessage.setReturn_msg("支付失败");
        }
        return payReturnMessage;
    }
    private Map<String,String> returnMap;
    private int status;
    private Long eid;

    /**
     *
     * @param json
     * {
     *      "eid":"xxxx",
     *      "status":"1"//1表示退单 2表示拒绝退单
     * }
     */
    @Autowired
    private PayBackEventService payBackEventService;
    @ResponseBody
    @RequestMapping("/refundOrder")
    public Map<String, String> refundOrder(@RequestBody String json) throws Exception {
        JSONObject object= JSON.parseObject(json);
        status=object.getInteger("status");
        eid=object.getLong("eid");
        sign=payBackEventService.payback(eid,status);
        returnMap=new HashMap<String, String>();
        return returnMap;
    }

}
