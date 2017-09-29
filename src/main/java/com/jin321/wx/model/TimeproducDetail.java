package com.jin321.wx.model;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Timeproduct;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/26 17:34
 * @Description :秒杀商品扩展类
 */
public class TimeproducDetail extends Timeproduct {
    List<Product> products;
    String ppicurl;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }
}
