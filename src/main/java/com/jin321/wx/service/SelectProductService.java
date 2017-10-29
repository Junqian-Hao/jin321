package com.jin321.wx.service;

import com.jin321.wx.model.ProductPo;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/14 16:10
 * @Description :搜索商品
 */
public interface SelectProductService {

    /**
     * 通过关键字搜索商品
     * @param key
     * @return
     * @throws Exception
     */
    List<ProductPo> selectProductBykey(String key,String code) throws Exception;

}
