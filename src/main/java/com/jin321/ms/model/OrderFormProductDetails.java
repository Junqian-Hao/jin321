package com.jin321.ms.model;

import com.jin321.pl.model.Orderformproduct;

public class OrderFormProductDetails {
    private Orderformproduct orderformproduct;
    private UpdateProductSizeDetail updateProductSizeDetail;

    public Orderformproduct getOrderformproduct() {
        return orderformproduct;
    }

    public void setOrderformproduct(Orderformproduct orderformproduct) {
        this.orderformproduct = orderformproduct;
    }

    public UpdateProductSizeDetail getUpdateProductSizeDetail() {
        return updateProductSizeDetail;
    }

    public void setUpdateProductSizeDetail(UpdateProductSizeDetail updateProductSizeDetail) {
        this.updateProductSizeDetail = updateProductSizeDetail;
    }
}
