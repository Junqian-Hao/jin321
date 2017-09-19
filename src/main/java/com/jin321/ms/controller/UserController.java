package com.jin321.ms.controller;

import com.jin321.ms.model.User;
import com.jin321.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author hao
 * @Date 2017/9/18 23:25
 * @Description :
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public User select() {
        System.out.println("lalalal");
        User user = userService.select();
        System.out.println(user);
        return user;
    }
}
