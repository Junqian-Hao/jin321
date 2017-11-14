package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.RollingPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/7.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteRollingPicController {
    @Autowired
    private RollingPicService rollingPicService;
    private Map<String,String> returnMap;
    private int rpid;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteRollingPic")
    public Map<String,String> deleteRollingPic(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        rpid=object.getInteger("rpid");
        sign=rollingPicService.deleteRollingPic(rpid);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","不存在此轮播图");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","轮播图删除失败");
            return returnMap;
        }
        else {
            returnMap.put("code","1");
            returnMap.put("msg","轮播图删除成功");
            return returnMap;
        }
    }
}
