package com.jin321.wx.controller;

import com.jin321.pl.model.Producttype;
import com.jin321.pl.utils.StringUtil;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.TypeService;
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
 * @Date 2017/10/7 22:10
 * @Description :商品种类查询
 */
@Controller
@RequestMapping("/wx")
public class TypeController {
    private static final Log log = LogFactory.getLog(TypeController.class);
    @Autowired
    TypeService typeService;

    @RequestMapping("/selectAllFirstProducttype")
    @ResponseBody
    public List<Producttype> selectAllFirstProducttype() throws Exception {
        log.info("查询所有一级分类");
        List<Producttype> producttypes = typeService.selectAllFirstProducttype();
        return producttypes;
    }

    @RequestMapping("/selectSecondProducttype")
    @ResponseBody
    public List<Producttype> selectSecondProducttype(@RequestBody Map<String, String> re) throws Exception {
        String tid = re.get("tid");
        log.info("查询一级标签下属的二级标签->"+tid);
        List<Producttype> producttypes = typeService.selectSecondProducttype(Integer.parseInt(tid));
        return producttypes;
    }
    @RequestMapping("/selectProductByptypeb")
    @ResponseBody
    public List<ProductPo> selectProductByptypeb(@RequestBody Map<String, String> re) throws Exception {
        String ptypeb = re.get("ptypeb");
        String code = re.get("code");
        log.info("通过三级标签id查询下属商品ptypeb->"+ptypeb+"code->"+code);
        if (StringUtil.isNullString(code)) {
            code = "0";
        }
        List<ProductPo> producttypes = typeService.selectProductByptypeb(Integer.parseInt(ptypeb),code);
        return producttypes;
    }
}
