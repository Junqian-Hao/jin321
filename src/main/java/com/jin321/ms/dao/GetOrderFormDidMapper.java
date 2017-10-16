package com.jin321.ms.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : 获取oid
 */
@Repository
public interface GetOrderFormDidMapper {
    int getDid(Long oid);
}
