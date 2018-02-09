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

    /**
     * 通过uid查询全部订单
     * @param uid
     * @return
     */
    List<OrderformProductDetail> selectOrderformByuid(@Param("uid")String uid);

    /**
     * 通过uid查询未支付订单
     * @param uid
     * @return
     */
    List<OrderformProductDetail> selectNOTPAYOrderformByuid(@Param("uid")String uid);

    /**
     * 通过uid查询未收货订单
     * @param uid
     * @return
     */
    List<OrderformProductDetail> selectNOTRECEIVEOrderformByuid(@Param("uid")String uid);

    /**
     * 通过uid查询付款未发货订单
     * @param uid
     * @return
     */
    List<OrderformProductDetail> selectNOTShipmentsOrderformByuid(@Param("uid")String uid);

    /**
     * 通过oid查询订单
     * @param oid
     * @return
     */
    OrderformProductDetail selectOrderformByoid(@Param("oid")Long oid);

    /**
     * 给订单设置支付单号
     * @param oid
     * @param dbfid
     */
    void updateDbfid(@Param("oid")Long oid,@Param("dbfid")long dbfid);

    /**
     * 修改订单的状态
     * @param oid
     * @param osdate
     */
    void updateOstade(@Param("oid")Long oid,@Param("osdate")long osdate);

}
