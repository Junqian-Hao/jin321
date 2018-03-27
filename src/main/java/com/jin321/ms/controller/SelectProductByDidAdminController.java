package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.model.UpdateProductSizeDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/ms")
public class SelectProductByDidAdminController {
    private static final Log log = LogFactory.getLog(SelectProductByDidAdminController.class);
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private int did;
    @ResponseBody
    @RequestMapping("/selectProductByDidAdmin")
    public List<UpdateProductSizeDetail> selectProduct(@RequestBody String json){
        log.info("管理员查询商家商品");
        JSONObject object= JSON.parseObject(json);
        did=object.getInteger("did");
        return productSizeDetailService.getDetailBydid(did);
    }
}
