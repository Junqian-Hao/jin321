package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.jin321.ms.Service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
/**
 * Created by Tyranitarx on 2017/10/17.
 *
 * @Description : 删除商品详细信息图片接口
 */
@Controller
@RequestMapping("/ms")
public class ProductDetailDeleteController {
    @Autowired
    private ProductDetailService productDetailService;
    private List<Integer> productDetailList;
    private Map<String,String> returnMap;
    private int sign;
    @RequestMapping("/productDetailDelete")
    @ResponseBody
    public Map<String,String> productDetailDelete(@RequestBody String json){
        productDetailList= JSON.parseArray(json,Integer.class);
        sign=productDetailService.productDetailDelete(productDetailList);
        if(sign==1){
            returnMap.put("code","1");
            returnMap.put("msg","删除成功");
            return returnMap;
        }else {
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }
    }
}
