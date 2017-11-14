package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.jin321.ms.Service.ProductPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/10/17.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteProductPicController {
    @Autowired
    private ProductPicService productPicService;
    private List<Integer> piclist;
    private int sign;
    private Map<String,String> returnMap;
    @RequestMapping("/deleteProductPics")
    @ResponseBody
    public Map<String,String>  deleteProductPics(@RequestBody String json){
        piclist= JSON.parseArray(json,Integer.class);
        sign=productPicService.productPicDelete(piclist);
        if(sign==1){
            returnMap.put("code","1");
            returnMap.put("msg","删除成功");
            return returnMap;
        }else {
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }
    }

}
