package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductSizeDetailService;


import com.jin321.ms.model.Page;
import com.jin321.ms.model.UpdateProductSizeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description : 获取商品信息详情
 */
@Controller
@RequestMapping("/ms")
public class SelectProductSizeDetailBydidController {
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private Page<UpdateProductSizeDetail> updateProductSizeDetailPage;
    private List<UpdateProductSizeDetail> updateProductSizeDetails;
    private Map<String,Object> returnMap;
    private int did;
    private int pagenum;
    private int thispage;
    private int isdeleted;// 0当前 1已删除 2待审核 3审核未通过
    @ResponseBody
    @RequestMapping("/getDetail1ByDid")
    public Map<String,Object> getPrductSizeDetail(@RequestBody String json,HttpServletRequest request) {
        returnMap=new LinkedHashMap<String, Object>();
        did = (Integer) request.getSession().getAttribute("did");
        JSONObject object= JSON.parseObject(json);
        pagenum = object.getInteger("pagenum");
        thispage = object.getInteger("thispage");
        isdeleted= object.getInteger("isdeleted");
        updateProductSizeDetailPage = productSizeDetailService.getDetailBydid(pagenum,thispage,did,isdeleted);
        updateProductSizeDetails=updateProductSizeDetailPage.getObjectList();
        if(updateProductSizeDetails!=null){
            returnMap.put("datapagenum",updateProductSizeDetails.size());
            returnMap.put("thispage",updateProductSizeDetailPage.getThispage());
            returnMap.put("totalpage",updateProductSizeDetailPage.getTotalpage());
            returnMap.put("pagedata",updateProductSizeDetails);
            return returnMap;
        }else {
            returnMap.put("error","页号错误");
            return returnMap;
        }
    }
}
