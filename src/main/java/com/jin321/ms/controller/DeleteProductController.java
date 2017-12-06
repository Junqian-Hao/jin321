package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
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
 * Created by Tyranitarx on 2017/10/11.
 *
 * @Description : 标记删除接口
 * 样例请求json: [
 *     "123","3435",······
 * ]
 */
@Controller
@RequestMapping("/ms")
public class DeleteProductController {
    private static final Log log = LogFactory.getLog(DeleteProductController.class);
    @Autowired
    private ProductService productService;
    private List<Integer> pids;
    private Map<String,String> returnMap;
    @RequestMapping("/deleteProduct")
    @ResponseBody
    public Map<String,String> deleteProduct(@RequestBody String json){
        log.info("用户删除商品");
        returnMap=new HashMap<String, String>();
        pids=JSON.parseArray(json,Integer.class);
        if(productService.deleteProduct(pids)==1){
             returnMap.put("code","1");
             returnMap.put("msg","删除成功");
             return returnMap;
        }
        else {
            returnMap.put("code","0");
            returnMap.put("msg","删除失败");
            return returnMap;
        }
    }
}
