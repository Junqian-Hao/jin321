package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductInsertService;
import com.jin321.ms.dao.ProductInsertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 添加货物服务
 */
@Service
public class ProductInsertServiceimp implements ProductInsertService {
    @Autowired
    private ProductInsertMapper productInsertMapper;
    /**
     * @param did 商品经销商ID
     * @param pname 商品名称
     * @param psummary 商品简介
     * @param ptypea 商品类型a
     * @param ptypeb 商品类型b
     * @param ptypec 商品类型v
     * @param is_together 是否合伙人商品
     * @return 1为添加成功 0为添加失败
     */
    @Override
    public int insertProduct(int did, String pname, String psummary, int ptypea, int ptypeb, int ptypec, int is_together) {
        return productInsertMapper.insertProduct(did, pname, psummary, ptypea, ptypeb, ptypec, is_together);
    }
}
