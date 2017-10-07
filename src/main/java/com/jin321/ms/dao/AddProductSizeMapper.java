package com.jin321.ms.dao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Tyranitarx on 2017/10/6.
 *
 * @Description : 为相应货物添加其具体款式
 */
@Repository("AddProductSizeMapper")
public interface AddProductSizeMapper {
    /**
     *
     * @param pid 货物编号
     * @param pcost 货物成本
     * @param psoriprice 货物原价
     * @param pssellprice 货物售价
     * @param sizename 款式名称
     * @param snumber 库存
     * @return 1成功 0失败
     */
    int addProductSize(int pid, BigDecimal pcost, BigDecimal psoriprice, BigDecimal pssellprice, String sizename, int snumber);
}
