package com.jin321.wx.dao;

import com.jin321.wx.model.FullProduct;
import org.apache.ibatis.annotations.Param;

/**
 * @Author hao
 * @Date 2017/10/2 16:47
 * @Description :
 */
public interface FullProductMapper {
    /**
     * 通过id查询商品详细信息
     * @param pid 商品id
     * @return 商品详细信息
     */
    FullProduct selectFullProductById(@Param("pid") int pid);
}
