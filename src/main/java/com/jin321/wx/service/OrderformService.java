package com.jin321.wx.service;

import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.model.OrderformProductDetail;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/11 14:20
 * @Description :订单业务逻辑
 */
public interface OrderformService {
    /**
     * 添加订单
     * @param orderformDetail
     * @return
     */
    boolean insertOrder(OrderformDetail orderformDetail) throws Exception;

    /**
     * 退单
     * @param oid
     * @return
     * @throws Exception
     */
    boolean chargebackOrder(long oid,String message) throws Exception;


    /**
     * 通过uid查询订单
     * @param uid
     * @return
     * @throws Exception
     */
    List<OrderformProductDetail> selectOrderByuid(String uid) throws Exception;
}