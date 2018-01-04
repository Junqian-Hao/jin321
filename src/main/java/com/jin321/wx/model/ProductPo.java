package com.jin321.wx.model;

import com.jin321.pl.model.Product;

import java.math.BigDecimal;

/**
 * @Author hao
 * @Date 2017/9/28 14:55
 * @Description :商品扩展类
 */
public class ProductPo extends Product {
    //商品缩略图
    private String ppicurl;
    //原价
    private BigDecimal psoriprice;
    //售价
    private BigDecimal pssellprice;

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }

    public BigDecimal getPsoriprice() {
        return psoriprice;
    }

    public void setPsoriprice(BigDecimal psoriprice) {
        this.psoriprice = psoriprice;
    }

    public BigDecimal getPssellprice() {
        return pssellprice;
    }

    public void setPssellprice(BigDecimal pssellprice) {
        this.pssellprice = pssellprice;
    }

    @Override
    public String toString() {
        return "com.jin321.wx.model.ProductPo{" +
                "ppicurl='" + ppicurl + '\'' +
                ", psoriprice=" + psoriprice +
                ", pssellprice=" + pssellprice +
                "} " + super.toString();
    }
}
