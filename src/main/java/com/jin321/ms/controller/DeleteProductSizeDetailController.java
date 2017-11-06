package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductSizeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteProductSizeDetailController {
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private Map<String,String> returnMap;
    private int sid;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteProductSize")
    public Map<String,String> deleteProductSize(@RequestBody String json){
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        sid=object.getInteger("sid");
        sign=productSizeDetailService.deleteDetail(sid);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","不存在此规格");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }
        else if(sign==4){
            returnMap.put("code","4");
            returnMap.put("msg","Product删除成功");
            return returnMap;
        }
        else if(sign==5){
            returnMap.put("code","5");
            returnMap.put("msg","不存在规格对应的Product");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","删除成功");
            return returnMap;
        }
    }
}
