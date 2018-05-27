package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.model.Page;
import com.jin321.ms.model.UpdateProductSizeDetail;
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
public class SelectProductByDidAdminController {
    private static final Log log = LogFactory.getLog(SelectProductByDidAdminController.class);
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private int did;
    private int pagenum;
    private int thispage;
    private int ptypea;
    private int ptypeb;
    private int ptypec;
    private Page<UpdateProductSizeDetail> updateProductSizeDetailPage;
    private List<UpdateProductSizeDetail> updateProductSizeDetails;
    private Map<String,Object> returnMap;
    @ResponseBody
    @RequestMapping("/selectProductByDidAdmin")
    public Map<String,Object> selectProduct(@RequestBody String json){
        log.info("管理员查询商家商品");
        returnMap=new LinkedHashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        did=object.getInteger("did");
        pagenum = object.getInteger("pagenum");
        thispage = object.getInteger("thispage");
        ptypea=object.getInteger("ptypea");
        ptypeb=object.getInteger("ptypeb");
        ptypec=object.getInteger("ptypec");
        updateProductSizeDetailPage = productSizeDetailService.getDetailBydid(did,pagenum,thispage,ptypea,ptypeb,ptypec);
        updateProductSizeDetails=updateProductSizeDetailPage.getObjectList();
        if(updateProductSizeDetails!=null){
            returnMap.put("datapagenum",updateProductSizeDetails.size());
            returnMap.put("thispage",updateProductSizeDetailPage.getThispage());
            returnMap.put("totalpage",updateProductSizeDetailPage.getTotalpage());
            returnMap.put("pagedata",updateProductSizeDetails);
            return returnMap;
        }else {
            returnMap.put("error","页号错误，或无内容");
            return returnMap;
        }
    }
}
