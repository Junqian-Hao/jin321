package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductService;
import com.jin321.ms.model.CheckedProductDetail;
import com.jin321.ms.model.Page;
import com.jin321.pl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class SelectReadyProductController {
    @Autowired
    private ProductService productService;
    private Map<String,Object> returnMap;
    private Page<CheckedProductDetail> checkedProductDetailPage;
    private List<CheckedProductDetail> checkedProductDetails;
    private int pagenum;
    private int thispage;

    @ResponseBody
    @RequestMapping("/selectReadyProduct")
    public Map<String, Object> getReadyProduct(@RequestBody String json){
        returnMap=new LinkedHashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        pagenum = object.getInteger("pagenum");
        thispage = object.getInteger("thispage");
        checkedProductDetailPage=productService.getReadyProduct(pagenum,thispage);
        checkedProductDetails=checkedProductDetailPage.getObjectList();
        if(checkedProductDetails!=null){
            returnMap.put("datapagenum",checkedProductDetails.size());
            returnMap.put("thispage",checkedProductDetailPage.getThispage());
            returnMap.put("totalpage",checkedProductDetailPage.getTotalpage());
            returnMap.put("pagedata",checkedProductDetails);
            return returnMap;
        }else {
            returnMap.put("error","页号错误");
            return returnMap;
        }
    }
}
