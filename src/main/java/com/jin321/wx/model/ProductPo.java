package com.jin321.wx.model;

import com.jin321.pl.model.Product;

/**
 * @Author hao
 * @Date 2017/9/28 14:55
 * @Description :商品扩展类
 */
public class ProductPo extends Product {
    private String ppicurl;
    private Long psoriprice;

    private Long pssellprice;

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }

    public Long getPsoriprice() {
        return psoriprice;
    }

    public void setPsoriprice(Long psoriprice) {
        this.psoriprice = psoriprice;
    }

    public Long getPssellprice() {
        return pssellprice;
    }

    public void setPssellprice(Long pssellprice) {
        this.pssellprice = pssellprice;
    }
}
