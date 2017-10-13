package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductPicService;
import com.jin321.ms.Service.ProductService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productsize;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 添加货物接口
 */
@Controller
@RequestMapping("/ms")
public class ProductInsertController {
    private static final Log log = LogFactory.getLog(ProductInsertController.class);
    @Autowired
    private ProductService productService;
    private Map<String,String> returnMap;
    private Product product;
    private List<Productsize> productsizes;

    /**
     *
     * @param json 样例json：
     * {
        "product":{"did":"1","pname":"郝俊谦最牛逼","psummary":"郝俊谦牛逼","ptypea":"1","ptypeb":"1","is_together":"1","is_delete":"0"},
        "productsizes":[{"pscost":"12.2","psoriprice":"12.2","pssellprice":"12.2","sizename":"郝俊谦牛逼","snumber":"123","is_delete":"0"}]
     *｝
     * @return
     */
    @RequestMapping("/insertProduct")
    @ResponseBody
    public Map<String,String> insertProduct(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject obj= JSON.parseObject(json);
        //product
        product=JSON.parseObject(obj.get("product").toString(),Product.class);
        //productsize
        productsizes=JSON.parseArray(obj.get("productsizes").toString(),Productsize.class);
        if (productService.insertProduct(product,productsizes)==1){
            returnMap.put("code","1");
            returnMap.put("msg","插入成功");
            return  returnMap;
        }
        else {
            returnMap.put("code","0");
            returnMap.put("msg","插入失败");
            return  returnMap;
        }
    }
}
