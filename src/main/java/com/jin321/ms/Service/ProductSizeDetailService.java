package com.jin321.ms.Service;

import com.jin321.ms.model.TrueUpdateProductSizeDetail;
import com.jin321.ms.model.UpdateProductSizeDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
public interface ProductSizeDetailService {
    /**
     * 获取显示商品详情
     * @param did
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    List<TrueUpdateProductSizeDetail> getDetailBydid(int did);

    /**
     * 更新商品详细信息
     * @param updateProductSizeDetail
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateDetail(UpdateProductSizeDetail updateProductSizeDetail);

    /**
     * 删除商品规格
     * @param sidlist
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int deleteDetail(List<Integer> sidlist);
}
