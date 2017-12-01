package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductTypeService;
import com.jin321.pl.model.Producttype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * Created by Tyranitarx on 2017/11/27.
 *
 * @Description :
 */

@RequestMapping("/ms")
public class InsertThridProductTypeController {
    private static final Log log = LogFactory.getLog(InsertFirstProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;
    private Map<String,String> returnMap;
    private String typename;
    private int higherid;
    private Producttype producttype;
    private int sign;
    @ResponseBody
    @RequestMapping("/insertThirdProductType")
    public Map<String,String> insertThirdProdcutType(@RequestBody String json){
        producttype=new Producttype();
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        typename=object.getString("typename");
        higherid=object.getInteger("higherid");
        producttype.setTypename(typename);
        sign=productTypeService.insertThirtType(producttype,higherid);
        if(sign==-1){
            returnMap.put("code", "-1");
            returnMap.put("msg", "分类已存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code", "0");
            returnMap.put("msg", "添加失败");
            return returnMap;
        }
        else{
            returnMap.put("code", "1");
            returnMap.put("msg", "添加成功");
            return returnMap;
        }
    }
}
