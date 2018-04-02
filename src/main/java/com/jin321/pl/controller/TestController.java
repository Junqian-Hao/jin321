package com.jin321.pl.controller;

import com.jin321.wx.controller.ChartController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: hao
 * @Date: 2018/3/26 21:41
 * @Description: *
 */
@Controller
public class TestController {
    private static final Log log = LogFactory.getLog(TestController.class);
    @RequestMapping("/")
    public String test() {
        log.info("访问首页");
        return "redirect:login.html";
    }
}
