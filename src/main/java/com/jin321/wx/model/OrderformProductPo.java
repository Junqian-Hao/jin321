package com.jin321.wx.model;

import com.jin321.pl.model.Orderformproduct;

/**
 * @Author hao
 * @Date 2017/10/16 16:19
 * @Description :订单详情下
 */
public class OrderformProductPo extends Orderformproduct {
    private Integer pid;

    private Integer did;

    private String pname;

    private String psummary;

    private Integer psellnum;

    private Integer ptypea;

    private Integer ptypeb;

    private Integer ptypec;

    private Boolean isTogether;

    private Boolean isDelete;
    //商品缩略图
    private String ppicurl;

}