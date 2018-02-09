package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.model.OrderFormDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :改变订单状态接口 样例参数{
 *      "oid":"xxx",
 *      "ostate":"ostate"
 * }
 */
@Controller
@RequestMapping("/ms")
public class ChangeOrderFormStatueController {
    private static final Log log = LogFactory.getLog(ChangeOrderFormStatueController.class);
    @Autowired
    private OrderFormService orderFormService;
    private Long oid;
    private String osendmethod;
    private String osendnumber;
    private int sign;
    private List<OrderFormDetails> orderFormDetailsList;
    private Map<String,String> returnMap;
    @ResponseBody
    @RequestMapping("/getOrderform")
    public List<OrderFormDetails> getOrderForm(@RequestBody String json, HttpServletRequest request){
        //未发货1 未确认2 确认3
        JSONObject object=JSON.parseObject(json);
        int select=object.getInteger("select");
       // int did=(Integer)request.getSession().getAttribute("did");

        switch (select){
            case 1:
                orderFormDetailsList =orderFormService.getUnReadyOrderfrom(2);break;
            case 2:
                orderFormDetailsList =orderFormService.getReadyOrderform(2);break;
            case 3:
                orderFormDetailsList =orderFormService.getconfirmForm(2);break;
        }
        return orderFormDetailsList;
    }
    //发货接口
    @ResponseBody
    @RequestMapping("/changeOrderStatue")
    public Map<String,String> changeStatue(@RequestBody String json){
        log.info("改变订单状态");
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        oid=(Long) object.get("oid");
        osendmethod=object.getString("osendmethod");
        osendnumber=object.getString("osendnumber");
        sign=orderFormService.sendOrderFormStatue(oid,osendmethod,osendnumber);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","此订单不存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","修改失败");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","修改成功");
            return returnMap;
        }
    }
}
