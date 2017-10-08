package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductInsertService;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 添加货物服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInsertServiceimp implements ProductInsertService {
    @Autowired
    private ProductMapper productMapper;
    /**
     *
     * @param product 插入product对象
     * @return 1成功 0失败
     */
    @Override
    public int insertProduct(Product product) {
        return productMapper.insert(product);
    }
}
