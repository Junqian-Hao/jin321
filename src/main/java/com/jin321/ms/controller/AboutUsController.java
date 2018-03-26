package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ms")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;
    private Map<String,String> returnMap;
    @RequestMapping("/updateAbout")
    public Map<String,String> updateAbout(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        String text=object.getString("text");
        if(aboutUsService.updateaboutus(text)==1){
            returnMap.put("code","1");
            returnMap.put("msg","更新成功");
            return returnMap;
        }else {
            returnMap.put("code","0");
            returnMap.put("msg","更新失败");
            return returnMap;
        }
        }
}
