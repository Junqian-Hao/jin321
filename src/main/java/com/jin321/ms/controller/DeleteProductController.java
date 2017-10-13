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
 * Created by Tyranitarx on 2017/10/11.
 *
 * @Description : 标记删除接口
 * 样例请求json:    {
 *                      "pid":"1"
 *                  }
 */
@Controller
@RequestMapping("/ms")
public class DeleteProductController {
    @Autowired
    private ProductService productService;
    private int pid;
    private Map<String,String> returnMap;
    @RequestMapping("/deleteproduct")
    @ResponseBody
    public Map<String,String> deleteProduct(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject obj= JSON.parseObject(json);
        pid=obj.getInteger("pid");
        if(productService.deleteProduct(pid)==1){
             returnMap.put("code","1");
             returnMap.put("msg","删除成功");
             return returnMap;
        }
        else {
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }
    }
}
