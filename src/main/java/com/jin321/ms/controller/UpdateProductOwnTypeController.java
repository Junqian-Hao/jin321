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
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description : 修改商品分类接口
 * {
 *  "ptypea":"",
 *  "ptypeb":""
 * }
 */
@Controller
@RequestMapping("/ms")
public class UpdateProductOwnTypeController {
    @Autowired
    private ProductService productService;
    private int pid;
    private int ptypea;
    private int ptypeb;
    private int sign;
    private Map<String,String> returnMap;
    @ResponseBody
    @RequestMapping("/updateProductOwnType")
    public Map<String,String> updateProductOwnType(@RequestBody String json) {
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        pid=object.getInteger("pid");
        ptypea=object.getInteger("ptypea");
        ptypeb=object.getInteger("ptypeb");
        sign=productService.updateProductType(pid,ptypea,ptypeb);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","不存在的分类");
            return returnMap;
        }
        else if(sign==1){
            returnMap.put("code","1");
            returnMap.put("msg","修改成功");
            return returnMap;
        }else {
            returnMap.put("code","0");
            returnMap.put("msg","修改失败");
            return returnMap;
        }
    }
}
