package com.jin321.ms.controller;


import com.jin321.ms.Service.OrderFormProductService;
import com.jin321.ms.Service.PayBackEventService;
import com.jin321.ms.WebSocket.PayBackEventHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;

import java.util.Map;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : 郝俊谦要的接口
 * 样例json：{"oid":"xxxxxxxxxx"}
 */

@Controller
@RequestMapping("/ms")
public class WarnPayBackEventController {
    private static final Log log = LogFactory.getLog(WarnPayBackEventController.class);
    private Map<String,String> returnMap;
    private Long oid;
    private String msg;
    private int did;
    @Autowired
    private OrderFormProductService orderFormProductService;
    @Autowired
    private PayBackEventService payBackEventService;
    @Bean//这个注解会从Spring容器拿出Bean
    public PayBackEventHandler eventHandler() {
        return new PayBackEventHandler();
    }
    @RequestMapping("/getpaybackevent")
    public Map<String,String> getPayBackEvent(@RequestParam("oid") Long oid,@RequestParam("msg") String msg)throws Exception{
        did=orderFormProductService.getOrderDid(oid);
        eventHandler().sendMessageToUser(Integer.toString(did),new TextMessage("您的订单号为"+oid+"的订单申请取消订单，请注意处理"));
        if(payBackEventService.insertpaybackevent(oid,did,msg)==1){
            returnMap.put("code","1");
            returnMap.put("msg","请求成功");
            return returnMap;
        }
        else {
            returnMap.put("code","0");
            returnMap.put("msg","请求失败");
            return returnMap;
        }
    }
}
