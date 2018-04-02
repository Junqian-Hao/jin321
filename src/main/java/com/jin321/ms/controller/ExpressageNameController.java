package com.jin321.ms.controller;

import com.jin321.ms.Service.ExpressageService;
import com.jin321.pl.model.Expressage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ms")
public class ExpressageNameController {
    @Autowired
    private ExpressageService expressageService;
    @RequestMapping("/getExpressage")
    @ResponseBody
    public List<Expressage> getExpressage(){
        return expressageService.getExpressage();
    }
}
