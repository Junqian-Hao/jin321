package com.jin321.ms.dao;

import com.jin321.ms.model.UpdateProductSizeDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface GetProductSizeDetailBySidMapper {
    public UpdateProductSizeDetail getDetial(int sid);
}
