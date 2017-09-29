package com.jin321.wx.dao;

import com.jin321.wx.model.ProductPo;

import java.util.List;

/**
 * 商品扩展类
 *
 * @Author hao
 * @Date 2017/9/26 22:18
 * @Description :
 */
public interface ProductPoMapper {
    List<ProductPo> selectAllTogether();

}
