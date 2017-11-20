package com.jin321.ms.model;

import com.jin321.pl.model.Producttype;

import java.util.List;

public class TrueProductType {
    private Producttype producttype1;
    private List<Producttype> producttype2List;

    public Producttype getProducttype1() {
        return producttype1;
    }

    public void setProducttype1(Producttype producttype1) {
        this.producttype1 = producttype1;
    }

    public List<Producttype> getProducttype2List() {
        return producttype2List;
    }

    public void setProducttype2List(List<Producttype> producttype2List) {
        this.producttype2List = producttype2List;
    }
}
