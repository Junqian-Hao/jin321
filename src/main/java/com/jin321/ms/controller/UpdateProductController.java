package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.model.UpdateProductSizeDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2017/10/13.
 *
 * @Description :样例json
 * {
 * "sid":"",
 * "pid":"",
 * "pname":"",
 * "psummary":"",
 * "psoriprice":"",
 * "pssellprice":"",
 * "sizename":"",
 * "snumber":""}
 */
@Controller
@RequestMapping("/ms")
public class UpdateProductController {
    private static final Log log = LogFactory.getLog(UpdateProductController.class);
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private UpdateProductSizeDetail updateProductSizeDetail;
    private int sign;
    private Map<String,String> returnMap;
    @RequestMapping("/updateProduct")
    @ResponseBody
    public Map<String,String> updateProduct(@RequestBody String json) {
        log.info("更新商品信息");
        returnMap=new HashMap<String, String>();
        updateProductSizeDetail=JSON.parseObject(json,UpdateProductSizeDetail.class);
        sign=productSizeDetailService.updateDetail(updateProductSizeDetail);
        if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","更新失败");
            return returnMap;
        }
        else {
            returnMap.put("code","1");
            returnMap.put("msg","更新成功");
            return returnMap;
        }
    }

}
