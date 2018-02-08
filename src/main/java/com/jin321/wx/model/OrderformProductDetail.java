package com.jin321.wx.model;

import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Useraddress;
import com.jin321.wx.utils.WXUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/16 15:28
 * @Description :订单商品模型
 */
public class OrderformProductDetail extends Orderform {
    //用户收货地址信息
    Useraddress useraddress;
    //订单商品详细信息
    List<OrderformProductPo> orderformProductPos;

    private String dname;

    //baseUrl

    String baseURL = WXUtil.BASEPATH;

    //订单总价
    private BigDecimal totalprice;

    public Useraddress getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(Useraddress useraddress) {
        this.useraddress = useraddress;
    }

    public List<OrderformProductPo> getOrderformProductPos() {
        return orderformProductPos;
    }

    public void setOrderformProductPos(List<OrderformProductPo> orderformProductPos) {
        this.orderformProductPos = orderformProductPos;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
