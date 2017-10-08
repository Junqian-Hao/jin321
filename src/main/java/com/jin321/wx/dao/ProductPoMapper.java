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
    /**
     * 查询所有未标记为删除的合伙人商品
     * @return
     */
    List<ProductPo> selectAllNowTogether();

    /**
     *根据二级标签id查询未删除的商品
     * @return
     */
    List<ProductPo> selectNowByPtypeb(int ptypeb);
}
