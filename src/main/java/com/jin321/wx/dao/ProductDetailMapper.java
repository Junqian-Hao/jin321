package com.jin321.wx.dao;

import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/26 22:18
 * @Description :
 */
public interface ProductDetailMapper {
    /**
     * 查询合伙人商品简略信息
     * @return
     */
    Map<String, Object> selectSimpleTogether();

}
