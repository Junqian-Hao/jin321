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
 * Created by Tyranitarx on 2017/10/30.
 *
 * @Description :添加限时秒杀商品
 * 样例json:("pid":{[1,2,3,4,2,3]})
 */
@Controller
@RequestMapping("/ms")
public class CreateHotProductController {
    private static final Log log = LogFactory.getLog(CreateHotProductController.class);
    @Autowired
    private TimeProductService timeProductService;
    private List<Integer> hotproductlist;
    private Map<String, String> returnMap;
    private int sign;

    @RequestMapping("/createTimeproduct")
    @ResponseBody
    public Map<String, String> createTimeProdut(@RequestBody String json) {
        log.debug("进入添加活动控制器");
        returnMap = new HashMap<String, String>();
        JSONObject object=JSON.parseObject(json);
        hotproductlist = (List<Integer>) object.get("pid");
        sign = timeProductService.createTimeProduct(hotproductlist);
        if (sign == 0) {
            returnMap.put("code", "0");
            returnMap.put("msg", "插入失败");
            return returnMap;
        } else if (sign == -1) {
            returnMap.put("code", "2");
            returnMap.put("msg", "已存在该商品相关的活动");
            return returnMap;
        } else {
            returnMap.put("code", "1");
            returnMap.put("msg", "添加成功");
            return returnMap;
        }
    }
}
