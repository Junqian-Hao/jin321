package com.jin321.ms.Service;

import com.jin321.pl.model.Productpics;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description :相关图片上传接口
 */
public interface ProductPicService {
    /**
     * 添加图片
     * @param productpics
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int productPicUpdate(Productpics productpics);

    /**
     * 删除图片
     * @param productPicsList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int productPicDelete(List<Integer> productPicsList);
}
