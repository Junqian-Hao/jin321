package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductPicService;
import com.jin321.pl.model.Productpics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class SelectProductPicsNowController {
    @Autowired
    private ProductPicService productPicService;
    private List<Productpics> productpicsList;
    private int pid;
    @ResponseBody
    @RequestMapping("/selectPics")
    public List<Productpics> selectPics(@RequestBody String json, HttpServletRequest request){
        JSONObject object= JSON.parseObject(json);
        pid=(Integer)object.get("pid");
        productpicsList=productPicService.selectProductPicNow(pid);
        return productpicsList;
    }
}
