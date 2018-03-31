package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ShowPayCommisionService;
import com.jin321.ms.model.Page;
import com.jin321.pl.model.Paycommision;
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
public class PayCommisionController {
    @Autowired
    private ShowPayCommisionService payCommisionService;
    private Page<Paycommision> paycommisionPage;
    private List<Paycommision> paycommisions;
    private int thispage;
    private int pagenum;
    private Map<String,Object> returnMap;
    @ResponseBody
    @RequestMapping("/showCommisions")
    public Map<String,Object> showPayCommision(@RequestBody String json){
        returnMap=new LinkedHashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        pagenum=object.getInteger("pagenum");
        thispage=object.getInteger("thispage");
        paycommisionPage=payCommisionService.getAllPaycommision(pagenum,thispage);
        paycommisions=paycommisionPage.getObjectList();
        if(paycommisions!=null){
            returnMap.put("datapagenum",paycommisions.size());
            returnMap.put("thispage",paycommisionPage.getThispage());
            returnMap.put("totalpage",paycommisionPage.getTotalpage());
            returnMap.put("pagedata",paycommisions);
            return returnMap;
        }else {
            returnMap.put("error","页号错误，或无内容");
            return returnMap;
        }
    }

}
