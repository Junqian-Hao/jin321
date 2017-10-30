package com.jin321.ms.controller;

import com.jin321.ms.util.CaptchaUtil;
import com.jin321.pl.utils.JWTUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 获取验证码
 */
@Controller
@RequestMapping("/ms")
public class CaptchaController {
    private static final Log log = LogFactory.getLog(CaptchaController.class);
    private String verifyCode;
    private Map<String,Object> verifyCodeMap;
    private String verifycodeJWT;
    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        verifyCodeMap=new HashMap<String, Object>();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        verifyCode=CaptchaUtil.generateVerifyCode(4);
        log.info("验证码为："+verifyCode);
        verifyCodeMap.put("verifycode",verifyCode.toString());
        verifycodeJWT= JWTUtil.createJWT(verifyCodeMap);
        response.setHeader("verifycodeJWT",verifycodeJWT);
        int w=75,h=34;
        try {
            CaptchaUtil.outputImage(w,h,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
