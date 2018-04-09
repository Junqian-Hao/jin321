package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductTypeService;
import com.jin321.pl.model.Producttype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author TyranitarX
 * @Date 2017/11/16 21:35
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class InsertFirstProductTypeController {
    private static final Log log = LogFactory.getLog(InsertFirstProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private RedisTemplate redisTemplate;
    private Map<String,String> returnMap;
    private String typename;
    private Producttype producttype;
    private int sign;
    @ResponseBody
    @RequestMapping("/insertFirstProductType")
    public Map<String,String> insertFirstProdcutType(@RequestBody String json){
        log.info("添加一级分类传来的添加FTjson为"+json);
        producttype=new Producttype();
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        typename=object.getString("typename");
        producttype.setTypename(typename);
        sign=productTypeService.insertFirstType(producttype);
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
