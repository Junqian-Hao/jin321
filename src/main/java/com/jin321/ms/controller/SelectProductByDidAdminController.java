package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductService;
import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.model.TrueProduct;
import com.jin321.ms.model.TrueUpdateProductSizeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/ms")
public class SelectProductByDidAdminController {
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private int did;
    @ResponseBody
    @RequestMapping("/selectProductByDidAdmin")
    public List<TrueUpdateProductSizeDetail> selectProduct(@RequestBody String json){
        JSONObject object= JSON.parseObject(json);
        did=object.getInteger("did");
        return productSizeDetailService.getDetailBydid(did);
    }
}