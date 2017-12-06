package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductTypeService;
import com.jin321.ms.model.TrueProductType;
import com.jin321.pl.model.Producttype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/ms")
public class SelectAllProductTypeController {
    private static final Log log = LogFactory.getLog(SelectAllProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;
    @ResponseBody
    @RequestMapping("/selectAllProductType")
    public List<TrueProductType> getAllTypes(){
        log.info("查询所有商品分类");
        return productTypeService.getAllTypes();
    }
}
