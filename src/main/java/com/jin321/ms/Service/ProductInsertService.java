package com.jin321.ms.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description :
 */
public interface ProductInsertService {
    /**
     *
     * @param did 商品经销商ID
     * @param pname 商品名称
     * @param psummary 商品简介
     * @param ptypea 商品类型a
     * @param ptypeb 商品类型b
     * @param ptypec 商品类型v
     * @param is_together 是否合伙人商品
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int insertProduct(int did,String pname,String psummary,int ptypea,int ptypeb,int ptypec,int is_together);
}
