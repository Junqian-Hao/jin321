package com.jin321.ms.dao;

import com.jin321.ms.model.CheckedProductDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetUnCheckedProudctMapper {
    List<CheckedProductDetail> getUnCheckedProductSizeDetail();
}
