package com.jin321.wx.dao;

import com.jin321.wx.model.SimpleProduct;

/**
 * @Author hao
 * @Date 2017/9/27 12:57
 * @Description :
 */
public interface SimpleProductMapper {
    SimpleProduct selectNowSimpleProduct(Integer pid);
}
