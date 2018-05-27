package com.jin321.ms.dao;

import com.jin321.ms.model.TrueProduct;

import java.util.List;

public interface GetProductDidMapper {
    public List<TrueProduct> getTrueProduct(int did,int ptypea,int ptypeb,int ptypec);
}
