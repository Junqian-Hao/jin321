package com.jin321.ms.controller;

import com.jin321.ms.util.CaptchaUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        verifyCode=CaptchaUtil.generateVerifyCode(4);
        request.getSession().setAttribute("verifycode",verifyCode);
        log.info("验证码为："+request.getSession().getAttribute("verifycode"));
        int w=75,h=26;
        try {
            CaptchaUtil.outputImage(w,h,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
