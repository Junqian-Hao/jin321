package com.jin321.wx.controller;

import com.jin321.wx.model.FullProduct;
import com.jin321.wx.service.FullProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/2 17:25
 * @Description : 查询商品详细信息
 */
@Controller
@RequestMapping("/wx")
public class FullProductController {
    private static final Log log = LogFactory.getLog(FullProductController.class);
    @Autowired
    FullProductService fullProductService;

    /**
     * 通过id查询商品详细信息
     *
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectFullProductById")
    @ResponseBody
    public FullProduct selectFullProductById(@RequestBody Map<String, String> re, HttpServletRequest request) throws Exception {
        String pid = re.get("pid");
        log.info("通过id查询商品信息，商品id" + pid);
        FullProduct fullProduct = fullProductService.selectFullProductById(Integer.parseInt(pid));
        fullProduct.setBasePathNoPort("https://www.jin321.cn/jin321/");
        return fullProduct;
    }
}
