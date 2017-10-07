package com.jin321.ms.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Tyranitarx on 2017/10/1.
 *
 * @Description : 经销商添加商品
 */
@Repository("ProductInsertMapper")
public interface ProductInsertMapper {
    /**
     * @param did 经销商id
     * @param pname 商品名称
     * @param psummary 商品简介
     * @param ptypea 商品类别a
     * @param ptypeb 商品类别b
     * @param ptypec 商品类别c
     * @param is_together 是否合伙商品
     * @return 插入成功/失败
     */
    int insertProduct(int did,String pname,String psummary,int ptypea,int ptypeb,int ptypec,int is_together);
}
