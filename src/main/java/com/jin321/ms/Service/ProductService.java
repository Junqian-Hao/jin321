package com.jin321.ms.Service;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productdetail;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.Productsize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 商品相关接口
 */
public interface ProductService {
    /**
     *
     * @param product 商品信息
     * @param productsizes 商品款式
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int insertProduct(Product product, List<Productsize> productsizes);
    @Transactional(rollbackFor = Exception.class)
    int deleteProduct(List<Integer> pids);
    @Transactional(rollbackFor = Exception.class)
    int updateProduct(Product product,List<Productsize> productsizes);
}
