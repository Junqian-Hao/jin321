package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductInsertService;


import java.util.HashMap;
import java.util.Map;

import com.jin321.pl.model.Product;
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
    private ProductInsertService productInsertService;
    private Map<String,String> returnMap;
    private Product product;
    private int did;
    private String pname;
    private String psummary;
    private int ptypea;
    private int ptypeb;
    private int ptypec;
    private int is_together;
    @RequestMapping("/insertProduct")
    @ResponseBody
    public Map<String,String> insertProduct(@RequestBody String json){
        product=new Product();
        returnMap=new HashMap<String, String>();
        JSONObject obj= JSON.parseObject(json);
        did=obj.getInteger("did");
        pname=obj.getString("pname");
        psummary=obj.getString("psummary");
        ptypea=obj.getInteger("ptypea");
        ptypeb=obj.getInteger("ptypeb");
        is_together=obj.getInteger("is_together");
        product.setDid(did);
        product.setPname(pname);
        product.setPsummary(psummary);
        product.setPtypea(ptypea);
        product.setPtypeb(ptypeb);
        product.setIsTogether((is_together==1)?true:false);
        if(productInsertService.insertProduct(product)==1){
            returnMap.put("code","1");
            return returnMap;
        }
        else {
            returnMap.put("code","0");
            return returnMap;
        }
    }
}
