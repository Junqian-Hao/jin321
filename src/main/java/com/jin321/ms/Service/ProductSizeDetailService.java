package com.jin321.ms.Service;

import com.jin321.ms.model.Page;
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
     * @param
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    Page<UpdateProductSizeDetail> getDetailBydid(int did,int pagenum,int thispage,int ptypea,int ptypeb,int ptypec);

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
    int deleteDetail(List<String> sidlist);
}
