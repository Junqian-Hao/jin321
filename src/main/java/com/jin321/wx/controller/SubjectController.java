package com.jin321.wx.controller;

import com.jin321.wx.model.Subject;
import com.jin321.wx.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author hao
 * @Date 2017/9/19 0:06
 * @Description :
 */
@Controller
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @RequestMapping("/select")
    @ResponseBody
    public Subject select() {
        System.out.println("lalalal");
        Subject select = subjectService.select();
        System.out.println(select);
        return select;
    }
}
