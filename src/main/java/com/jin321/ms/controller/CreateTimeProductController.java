package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.jin321.ms.Service.TimeProductService;
import com.jin321.pl.model.Timeproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/10/30.
 *
 * @Description :添加限时秒杀商品
 * 样例json:{"pid":"xx",
 *          "timestart":"xx",
 *          "timeend":"xx"}
 */
@Controller
@RequestMapping("/ms")
public class CreateTimeProductController {
    @Autowired
    private TimeProductService timeProductService;
    private Timeproduct timeproduct;
    private Map<String,String> returnMap;
    private int sign;
    @RequestMapping("/createTimeproduct")
    @ResponseBody
    public Map<String,String> createTimeProdut(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        timeproduct= JSON.parseObject(json,Timeproduct.class);
        sign=timeProductService.createTimeProduct(timeproduct);
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","插入失败");
            return returnMap;
        }
        else if(sign==-1){
            returnMap.put("code","2");
            returnMap.put("msg","已存在该商品相关的活动");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","添加成功");
            return returnMap;
        }
    }
}
