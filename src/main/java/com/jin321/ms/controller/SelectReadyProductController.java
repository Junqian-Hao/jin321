package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductService;
import com.jin321.pl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class SelectReadyProductController {
    @Autowired
    private ProductService productService;
    @ResponseBody
    @RequestMapping("/selectReadyProduct")
    public List<Product> getReadyProduct(){
        return productService.getReadyProduct();
    }
}
