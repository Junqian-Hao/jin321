package com.jin321.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.wx.service.PayBackEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2018/1/24.
 *
 * @Description :样例json{
 *     "oid":"xxxx",
 *     "did":"xxx",
 *     "pid":"xxx",
 *     "backmoney":"xxx",
 *     "message":"xxxx"
 * }
 */
@RequestMapping("wx")
public class PayBackEventController {
    @Autowired
    private PayBackEventService payBackEventService;
    private int sign;
    private Map<String,String> returnMap;
    @RequestMapping("/gengrateRefund")
    public Map<String,String> generateRefund(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        sign=payBackEventService.generateEvent(object.getLong("oid"),object.getInteger("did")
        ,object.getBigDecimal("backmoney"),object.getString("message"),object.getInteger("pid"));
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","退单生成失败请重新申请");
            return returnMap;
        }
        else {
            returnMap.put("code","1");
            returnMap.put("msg","退单请求生成成功，等待后台处理");
            return returnMap;
        }
    }
}
