package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.DealerLoginService;


import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tyranitarx on 2017/10/1.
 *
 * @Description : 经销商登录控制器
 */
@Controller
@RequestMapping("/ms")
public class DealerLoginController{
    private static final Log log = LogFactory.getLog(DealerLoginController.class);
    @Autowired
    private DealerLoginService dealerLoginService;
    private String dusername;
    private String dpassword;
    private String verifycode;
    private String verifycodeget;
    private int sign;
    private Map<String,String> returnMap;

    /**
     *
     * @param json
     * @param request
     * @return 1登录成功 2用户不存在 0登录失败 3验证码错误
     */
    @RequestMapping("/dealerlogin")
    @ResponseBody
    public Map<String,String> dealerlogin(@RequestBody String json, HttpServletRequest request){
        returnMap=new HashMap<String, String>();
        JSONObject obj= JSON.parseObject(json);
        dusername=obj.getString("dusername");
        dpassword=obj.getString("dusername");
        verifycodeget=obj.getString("verifycode");
        log.debug("获取json参数"+json);
        verifycode=(String)request.getSession().getAttribute("verifycode");
        log.debug("获取到的验证码为："+verifycode);
        sign=dealerLoginService.Login(dusername,dpassword);
        if (verifycodeget!=null&&verifycodeget==verifycode) {
            if(sign==2){
                returnMap.put("code","2");
                returnMap.put("msg","用户不存在");
                return returnMap;
            }
            else if(sign==1){
                returnMap.put("code","1");
                returnMap.put("msg","登录成功");
                return returnMap;
            }
            else{
                returnMap.put("code","0");
                returnMap.put("msg","密码错误");
                return returnMap;
            }
        } else {
            returnMap.put("code","3");
            returnMap.put("msg","验证码错误");
            return returnMap;
        }

    }
}
