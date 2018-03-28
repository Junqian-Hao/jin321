package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.DealerService;
import com.jin321.ms.model.Page;
import com.jin321.pl.model.Dealer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description : 查询所有经销商接口
 */
@Controller
@RequestMapping("/ms")
public class SelectAllDealersController {
    private static final Log log = LogFactory.getLog(SelectAllDealersController.class);
    private Map<String,Object> returnMap;
    private List<Dealer> dealers;
    private int pagenum;
    private int thispage;
    @Autowired
    private DealerService dealerService;
    @ResponseBody
    @RequestMapping("/selectAllDealer")
    public Map<String, Object> selectAllDealer(@RequestBody String json){
        log.info("查询所有商家");
        returnMap=new LinkedHashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        pagenum=object.getInteger("pagenum");
        thispage=object.getInteger("thispage");
        Page<Dealer> dealerPage=dealerService.selectAllDealer(pagenum,thispage);
        if(dealers!=null){
            returnMap.put("datapagenum",dealers.size());
            returnMap.put("thispage",dealerPage.getThispage());
            returnMap.put("totalpage",dealerPage.getTotalpage());
            returnMap.put("pagedata",dealers);
            return returnMap;
        }else {
            returnMap.put("error","页号错误");
            return returnMap;
        }
    }
}
