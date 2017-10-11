package com.jin321.wx.dao;

import com.jin321.pl.model.Orderform;

/**
 * @Author hao
 * @Date 2017/10/11 14:54
 * @Description :订单操作
 */
public interface OrderformDetailMapper {

    /**
     * 插入订单
     * @param record
     * @return
     */
    int insert(Orderform record);

}
