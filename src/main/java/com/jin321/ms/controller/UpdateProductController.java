package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductService;
import com.jin321.pl.model.Product;
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
 * Created by Tyranitarx on 2017/10/13.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class UpdateProductController {
    private static final Log log = LogFactory.getLog(UpdateProductController.class);
    @Autowired
    private ProductService productService;
    private Map<String,String> returnMap;
    private Product product;
    private int sign;
    @RequestMapping("/updateproduct")
    @ResponseBody
    public Map<String,String> updateProduct(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        product=JSON.parseObject(json,Product.class);
        log.info("获取到的product"+json+"+"+product);
        sign=productService.updateProduct(product);
        if(sign==1){
            returnMap.put("code","1");
            returnMap.put("msg","更新成功");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","1");
            returnMap.put("msg","更新失败");
            return returnMap;
        }
        else{
            returnMap.put("code","2");
            returnMap.put("msg","商品不存在");
            return returnMap;
        }
    }
}
