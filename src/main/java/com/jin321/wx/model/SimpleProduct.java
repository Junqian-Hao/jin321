package com.jin321.wx.model;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.model.Rollingpick;

/**
 * @Author hao
 * @Date 2017/9/27 12:48
 * @Description :简略商品信息
 */
public class SimpleProduct extends Product {
    //商品缩略图信息
    Productpics productpics;
    //轮播图信息
    Rollingpick rollingpick;
    //商品规格
    Productsize productsize;

    public Productpics getProductpics() {
        return productpics;
    }

    public void setProductpics(Productpics productpics) {
        this.productpics = productpics;
    }

    public Rollingpick getRollingpick() {
        return rollingpick;
    }

    public void setRollingpick(Rollingpick rollingpick) {
        this.rollingpick = rollingpick;
    }

    @Override
    public String toString() {
        return "com.jin321.wx.model.SimpleProduct{" +
                "productpics=" + productpics +
                ", rollingpick=" + rollingpick +
                ", productsize=" + productsize +
                "} " + super.toString();
    }
}
