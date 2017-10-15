package com.jin321.ms.dao;

import com.jin321.pl.model.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by Tyranitarx on 2017/10/8.
 *
 * @Description :插入Product并获取其主键自增值
 */
@Repository("InsertProductMapper")
public interface InsertProductMapper {
    int insertProduct(Product product);
}
