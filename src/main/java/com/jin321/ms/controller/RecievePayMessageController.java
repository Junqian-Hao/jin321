package com.jin321.ms.controller;

import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.model.PayReturnMessage;
import com.jin321.ms.model.RecieveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;

/**
 * Created by Tyranitarx on 2017/12/21.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class RecievePayMessageController {
    @Autowired
    private OrderFormService orderFormService;
    private PayReturnMessage payReturnMessage;
    private int sign;
    @RequestMapping("/recievePayMessage")
    @ResponseBody
    public PayReturnMessage getReturnMessage(@RequestBody RecieveMessage recieveMessage)throws Exception{
        payReturnMessage=new PayReturnMessage();
        if(recieveMessage.getResult_code().equals("SUCCESS")){
            sign=orderFormService.changeOrderFormStatue(1,Long.parseLong(recieveMessage.getOut_trade_no()),new Date());
            if(sign==1){
                payReturnMessage.setReturn_code("SUCCESS");
                payReturnMessage.setReturn_msg("支付成功");
            }
            else {
                payReturnMessage.setReturn_msg("FAIL");
                payReturnMessage.setReturn_msg("支付状态修改失败");
            }
        }
        else{
            payReturnMessage.setReturn_code("FAIL");
            payReturnMessage.setReturn_msg("支付失败");
        }
        return payReturnMessage;
    }
}
