package com.jin321.wx.model;

import com.jin321.pl.model.Dealerbuyform;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hao
 * @Date 2018/2/4 12:23
 * @Description :支付单扩展类
 */
public class DealerbuyformPo extends Dealerbuyform implements Serializable {
    private List<OrderformProductDetail> orderformProductDetails;

    public List<OrderformProductDetail> getOrderformProductDetails() {
        return orderformProductDetails;
    }

    public void setOrderformProductDetails(List<OrderformProductDetail> orderformProductDetails) {
        this.orderformProductDetails = orderformProductDetails;
    }
}
