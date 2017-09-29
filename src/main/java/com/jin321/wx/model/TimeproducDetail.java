package com.jin321.wx.model;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Timeproduct;

/**
 * @Author hao
 * @Date 2017/9/26 17:34
 * @Description :秒杀商品扩展类
 */
public class TimeproducDetail extends Timeproduct {
    Product products;
    String ppicurl;
    //原价
    private Long psoriprice;
    //售价
    private Long pssellprice;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
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

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }
}
