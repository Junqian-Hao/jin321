package com.jin321.ms.controller;

import com.jin321.ms.util.CaptchaUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
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
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ImageIO.write(CaptchaUtil.generateCaptcha(request), "jpg", response.getOutputStream());
    }
}
