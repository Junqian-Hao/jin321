package com.jin321.wx.model;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Timeproduct;

import java.math.BigDecimal;

/**
 * @Author hao
 * @Date 2017/9/26 17:34
 * @Description :秒杀商品扩展类
 */
public class TimeproducDetail extends Timeproduct {
    Product products;
    String ppicurl;
    //原价
    private BigDecimal psoriprice;
    //售价
    private BigDecimal pssellprice;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

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
        return "com.jin321.wx.model.TimeproducDetail{" +
                "products=" + products +
                ", ppicurl='" + ppicurl + '\'' +
                ", psoriprice=" + psoriprice +
                ", pssellprice=" + pssellprice +
                "} " + super.toString();
    }
}
