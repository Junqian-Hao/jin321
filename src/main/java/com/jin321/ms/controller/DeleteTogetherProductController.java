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
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/12.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteTogetherProductController {
    @Autowired
    private ProductService productService;
    private Map<String,String> returnMap;
    private List<Integer> pids;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteTogeter")
    public Map<String, String> deleteTogeter(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        pids=JSON.parseArray(json,Integer.class);
        sign=productService.deleteTogetherProduct(pids);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("mgs","商品不存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("mgs","取消失败");
            return returnMap;
        }
        else {
            returnMap.put("code","1");
            returnMap.put("mgs","取消成功");
            return returnMap;
        }
    }
}
