package com.jin321.ms.Service;

import com.jin321.pl.model.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description :
 */
public interface ProductInsertService {
    /**
     *
     * @param product 插入product对象
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int insertProduct(Product product);
}
