package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductService;
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
 * @Description :审核接口
 */
@Controller
@RequestMapping("/ms")
public class CheckOutProductController {
    @Autowired
    private ProductService productService;
    private Map<String,String> returnMap;
    private int pid;
    private int check;
    private int sign;
    @ResponseBody
    @RequestMapping("/checkProduct")
    public Map<String,String> checkProduct(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        pid=object.getInteger("pid");
        check=object.getInteger("check");
        sign=productService.checkoutProduct(pid,check);
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","审核提交失败");
            return returnMap;
        }
        else if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","无此商品");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","审核提交成功！");
            return returnMap;
        }
    }
}
