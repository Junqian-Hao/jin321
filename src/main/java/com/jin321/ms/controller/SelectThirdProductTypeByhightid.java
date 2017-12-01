package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductTypeService;
import com.jin321.pl.model.Producttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/12/1.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class SelectThirdProductTypeByhightid {
    @Autowired
    private ProductTypeService productTypeService;
    @ResponseBody
    @RequestMapping("/selectThirdProductTypeByhightid")
    public List<Producttype> selectThird(@RequestBody String json){
        JSONObject object= JSON.parseObject(json);
        int tid=object.getInteger("tid");
        return productTypeService.getAllTypes1(tid);
    }
}
