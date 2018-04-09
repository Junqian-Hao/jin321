package com.jin321.ms.Service;

import com.jin321.pl.model.Productdetail;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description :添加商品详细信息图片
 */
public interface ProductDetailService {
    /**
     * 添加图片
     * @param productdetail
     * @return
     */
    int productDetailUpdate(Productdetail productdetail);
    /**
     * 删除图片
     * @param pid
     * @return
     */
    void productDetailDelete(int pid);


}
