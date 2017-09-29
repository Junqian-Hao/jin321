package com.jin321.wx.model;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Rollingpick;

/**
 * @Author hao
 * @Date 2017/9/26 17:19
 * @Description : 秒杀活动详细信息
 */
public class RollingpickDetail extends Rollingpick{
    Product products;
    String ppicurl;

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
}
