package com.jin321.wx.service;

import com.jin321.wx.model.FullProduct;

/**
 * @Author hao
 * @Date 2017/10/2 16:31
 * @Description :商品详细信息
 */
public interface FullProductService {
    /**
     * 通过id查询商品的详细信息
     * @param pid 商品id
     * @return 商品详细信息
     */
    FullProduct selectFullProductById(int pid);

}
