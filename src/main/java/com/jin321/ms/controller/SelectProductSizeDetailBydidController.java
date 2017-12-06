package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductSizeDetailService;

import com.jin321.ms.model.TrueUpdateProductSizeDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description : 获取商品信息详情
 */
@Controller
@RequestMapping("/ms")
public class SelectProductSizeDetailBydidController {
    @Autowired
    private ProductSizeDetailService productSizeDetailService;
    private List<TrueUpdateProductSizeDetail> trueUpdateProductSizeDetails;
    private int did;
    @ResponseBody
    @RequestMapping("/getDetail1ByDid")
    public List<TrueUpdateProductSizeDetail> getPrductSizeDetail(HttpServletRequest request) {
            did = (Integer) request.getSession().getAttribute("did");
        trueUpdateProductSizeDetails = productSizeDetailService.getDetailBydid(did);
        return trueUpdateProductSizeDetails;
    }
}
