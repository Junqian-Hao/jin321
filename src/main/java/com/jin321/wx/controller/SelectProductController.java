package com.jin321.wx.controller;

import com.jin321.pl.utils.StringUtil;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.SelectProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/14 16:51
 * @Description :搜索商品
 */
@Controller
@RequestMapping("/wx")
public class SelectProductController {
    private static final Log log = LogFactory.getLog(SelectProductController.class);
    @Autowired
    SelectProductService selectProductService;

    @RequestMapping("/selectProductBykey")
    @ResponseBody
    public List<ProductPo> selectProductBykey(@RequestBody Map<String,String> rq) throws Exception {
        log.info("搜索商品");
        String key = rq.get("key");
        String code = rq.get("code");
        log.info("key->"+key+"code->"+code);
        if (StringUtil.isNullString(code)) {
            code = "0";
        }
        List<ProductPo> productPos = selectProductService.selectProductBykey(key,code);
        return productPos;
    }

}
