package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 选择货物接口
 */
@Controller
@RequestMapping("/ms")
public class SelectProductIdController {
    private Integer pid;
    private Map<String,String> returnMap;
    @RequestMapping("/selectProduct")
    @ResponseBody
    public Map<String, String> selectProduct(@RequestBody String json, HttpServletRequest request){
        JSONObject obj= JSON.parseObject(json);
        pid=obj.getInteger("pid");
        if(pid==null){
            returnMap.put("code","0");
            returnMap.put("msg","json中不存在pid");
            return  returnMap;
        }
        else {
            request.getSession().setAttribute("pid",pid);
            returnMap.put("code","1");
            returnMap.put("msg","pid已保存在session中");
            return returnMap;
        }
    }
}
