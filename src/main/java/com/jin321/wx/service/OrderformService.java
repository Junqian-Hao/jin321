package com.jin321.wx.service;

import com.jin321.wx.model.OrderformDetail;
import com.jin321.wx.model.OrderformProductDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    Map insertOrder(OrderformDetail orderformDetail, HttpServletRequest request) throws Exception;

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
    List<OrderformProductDetail> selectOrderByuid(String uid,int code) throws Exception;

    /**
     * 支付未支付订单
     * @return
     */
    Map<String, Object> payOrder(Long oid, String session, HttpServletRequest request) throws Exception;

    /**
     * 删除订单
     * @param oid
     * @return
     * @throws Exception
     */
    Map<String, String> deleteOrder(Long oid) throws Exception;

    /**
     * 通过订单id查询订单
     *
     * @param oid
     * @return
     * @throws Exception
     */
    OrderformProductDetail selectOrderByoid(String oid) throws Exception;
}
