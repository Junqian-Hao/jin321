package com.jin321.ms.dao;

import com.jin321.ms.model.DealerSellProductDetail;
import com.jin321.ms.model.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetDealerSellProductDetaiMapper {
    public List<DealerSellProductDetail> getDealerSellProductDetail(int did,int days);
}
