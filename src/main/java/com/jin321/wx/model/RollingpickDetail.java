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
    //原价
    private Long psoriprice;
    //售价
    private Long pssellprice;

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

    @Override
    public String toString() {
        return "com.jin321.wx.model.RollingpickDetail{" +
                "products=" + products +
                ", ppicurl='" + ppicurl + '\'' +
                ", psoriprice=" + psoriprice +
                ", pssellprice=" + pssellprice +
                "} " + super.toString();
    }
}
