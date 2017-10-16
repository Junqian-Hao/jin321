package com.jin321.wx.dao;

import com.jin321.pl.model.Orderform;
import com.jin321.wx.model.OrderformProductDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<OrderformProductDetail> selectOrderformByuid(@Param("uid")String uid);

}
