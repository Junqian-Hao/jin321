package com.jin321.wx.dao;

import com.jin321.wx.model.ProductPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品扩展类
 *
 * @Author hao
 * @Date 2017/9/26 22:18
 * @Description :
 */
@Repository
public interface ProductPoMapper {
    /**
     * 查询所有未标记为删除的合伙人商品
     * @return
     */
    List<ProductPo> selectAllNowTogether();

    /**
     *根据二级标签id查询未删除的商品根据销量排序
     * @return
     */
    List<ProductPo> selectNowByPtypebByPsellnum(int ptypec);

    /**
     * 根据二级标签id查询未删除的商品根据价格排序
     * @param ptypec
     * @return
     */
    List<ProductPo> selectNowByPtypebByPrice(int ptypec);

    /**
     * 通过关键字模糊搜索商品,价格升序排列
     * @param key
     * @return
     */
    List<ProductPo> selectNowBykeyOrderByPrice(@Param("key")String key);

    /**
     * 通过关键字模糊搜索商品,销量降序排列
     * @param key
     * @return
     */
    List<ProductPo> selectNowBykeyOrderByPsellnum(@Param("key")String key);
}
