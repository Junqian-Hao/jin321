package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.TimeProductService;
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
 * Created by Tyranitarx on 2017/12/6.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class DeleteTimeProductController {
    private static final Log log = LogFactory.getLog(DeleteTimeProductController.class);
    @Autowired
    private TimeProductService timeProductService;
    private List<Integer> tpidlist;
    private Map<String,String> returnMap;
    private int sign;
    @ResponseBody
    @RequestMapping("/deleteTimeProduct")
    public Map<String,String> deleteTimeProduct(@RequestBody String json){
        log.info("删除秒杀活动");
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        tpidlist=(List<Integer>)object.get("tpid");
        sign=timeProductService.deleteTimeProduct(tpidlist);
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }else{
            returnMap.put("code","1");
            returnMap.put("msg","删除成功");
            return returnMap;
        }
    }
}
