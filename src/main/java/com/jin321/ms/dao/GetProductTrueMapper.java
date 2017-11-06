package com.jin321.ms.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
@Repository
public interface GetProductTrueMapper {
    List<TrueProduct> getTrueProduct(int did);
}
