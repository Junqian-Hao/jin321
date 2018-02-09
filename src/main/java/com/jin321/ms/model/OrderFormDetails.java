package com.jin321.ms.model;

import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;

import java.util.List;

public class OrderFormDetails {
    private Orderform orderform;
    private List<Orderformproduct> orderformproductList;

    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }

    public List<Orderformproduct> getOrderformproductList() {
        return orderformproductList;
    }

    public void setOrderformproductList(List<Orderformproduct> orderformproductList) {
        this.orderformproductList = orderformproductList;
    }
}
