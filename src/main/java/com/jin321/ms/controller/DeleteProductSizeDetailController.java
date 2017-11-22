package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.ProductSizeDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :样例json{"123","123","123"}
 */
@Controller
@RequestMapping("/ms")
public class DeleteProductSizeDetailController {
    private static final Log log = LogFactory.getLog(DeleteProductSizeDetailController.class);
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private Map<String,String> returnMap;
    private List<String> sidlist;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteProductSize")
    public Map<String,String> deleteProductSize(@RequestBody String json){
        log.debug("传来的json为："+json);
        returnMap=new HashMap<String, String>();
        JSONObject object=JSON.parseObject(json);
        sidlist=(List<String>)object.get("sid");
        sign=productSizeDetailService.deleteDetail(sidlist);
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
        else if(sign==2){
            returnMap.put("code","2");
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
