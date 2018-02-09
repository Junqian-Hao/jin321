package com.jin321.ms.model;

import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Useraddress;

import java.util.List;

public class OrderFormDetails {
    private Orderform orderform;
    private Useraddress useraddress;
    private List<OrderFormProductDetails> orderFormProductDetails;

    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }

    public Useraddress getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(Useraddress useraddress) {
        this.useraddress = useraddress;
    }

    public List<OrderFormProductDetails> getOrderFormProductDetails() {
        return orderFormProductDetails;
    }

    public void setOrderFormProductDetails(List<OrderFormProductDetails> orderFormProductDetails) {
        this.orderFormProductDetails = orderFormProductDetails;
    }
}
