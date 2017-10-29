package com.jin321.ms.Service;

import com.jin321.pl.model.Productdetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description :添加商品详细信息图片
 */
public interface ProductDetailService {
    @Transactional(rollbackFor = Exception.class)
    int productDetailUpdate(Productdetail productdetail);
    @Transactional(rollbackFor = Exception.class)
    int productDetailDelete(List<Integer> productdetailList);


}
