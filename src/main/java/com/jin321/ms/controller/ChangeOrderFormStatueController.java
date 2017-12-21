package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.OrderFormService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.Json;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :改变订单状态接口 样例参数{
 *      "oid":"xxx",
 *      "ostate":"ostate"
 * }
 */
@Controller
@RequestMapping("/ms")
public class ChangeOrderFormStatueController {
    private static final Log log = LogFactory.getLog(ChangeOrderFormStatueController.class);
    @Autowired
    private OrderFormService orderFormService;
    private Long oid;
    private int ostate;
    private int sign;
    private Map<String,String> returnMap;
    @ResponseBody
    @RequestMapping("/changeOrderStatue")
    public Map<String,String> changeStatue(@RequestBody String json){
        log.info("改变订单状态");
        returnMap=new HashMap<String, String>();
        JSONObject object= JSON.parseObject(json);
        oid=(Long) object.get("oid");
        ostate=(Integer)object.get("ostate");
        sign=orderFormService.changeOrderFormStatue(ostate,oid,new Date());
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","此订单不存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","修改失败");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","修改成功");
            return returnMap;
        }

    }
}
