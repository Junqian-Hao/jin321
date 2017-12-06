package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/12.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteTogetherProductController {
    private static final Log log = LogFactory.getLog(DeleteTogetherProductController.class);
    @Autowired
    private ProductService productService;
    private Map<String,String> returnMap;
    private List<String> pids;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteTogeter")
    public Map<String, String> deleteTogeter(@RequestBody String json){
        log.info("取消合伙人商品");
        returnMap=new HashMap<String, String>();
        JSONObject object=JSON.parseObject(json);
        pids=(List<String>) object.get("pid");
        sign=productService.deleteTogetherProduct(pids);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","商品不存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","取消失败");
            return returnMap;
        }
        else {
            returnMap.put("code","1");
            returnMap.put("msg","取消成功");
            return returnMap;
        }
    }
}
