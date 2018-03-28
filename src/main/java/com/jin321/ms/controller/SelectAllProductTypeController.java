package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductTypeService;
import com.jin321.ms.model.Page;
import com.jin321.ms.model.TrueProductType;
import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.Producttype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/ms")
public class SelectAllProductTypeController {
    private static final Log log = LogFactory.getLog(SelectAllProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;
    private Map<String,Object> returnMap;
    private Page<TrueProductType> trueProductTypePage;
    private List<TrueProductType> trueProductTypes;
    private int pagenum;
    private int thispage;
    @ResponseBody
    @RequestMapping("/selectAllProductType")
    public Map<String, Object> getAllTypes(@RequestBody String json){
        log.info("查询所有商品分类");
        returnMap=new LinkedHashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        pagenum=object.getInteger("pagenum");
        thispage=object.getInteger("thispage");
        trueProductTypePage=productTypeService.getAllTypes(pagenum,thispage);
        trueProductTypes=trueProductTypePage.getObjectList();
        if(trueProductTypes!=null){
            returnMap.put("datapagenum",trueProductTypes.size());
            returnMap.put("thispage",trueProductTypePage.getThispage());
            returnMap.put("totalpage",trueProductTypePage.getTotalpage());
            returnMap.put("pagedata",trueProductTypes);
            return returnMap;
        }else {
            returnMap.put("error","页号错误");
            return returnMap;
        }
    }
}
