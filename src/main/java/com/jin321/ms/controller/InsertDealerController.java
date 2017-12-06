package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.jin321.ms.Service.DealerService;
import com.jin321.pl.model.Dealer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class InsertDealerController {
    private static final Log log = LogFactory.getLog(InsertDealerController.class);
    @Autowired
    private DealerService dealerService;
    private Map<String, String> returnMap;
    private Dealer dealer;
    private int sign;
    @ResponseBody
    @RequestMapping("/insertDealer")
    public Map<String, String> insertDealer(@RequestBody String json) {
        log.info("添加商户传来的json为："+json);
        returnMap = new HashMap<String, String>();
        dealer = JSON.parseObject(json, Dealer.class);
        sign=dealerService.insertDealer(dealer);
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","添加失败");
            return returnMap;
        }
        else if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","已存在的商家");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","添加成功");
            return returnMap;
        }
    }
}
