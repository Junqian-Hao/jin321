package com.jin321.ms.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/4.
 *
 * @Description :
 */
@Repository
public interface SelectSidInFormMapper {
    List<Integer> selectsid(Long oid);
}
