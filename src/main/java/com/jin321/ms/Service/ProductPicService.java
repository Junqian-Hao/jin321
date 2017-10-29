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
    @Transactional(rollbackFor = Exception.class)
    int productPicUpdate(Productpics productpics);
    @Transactional(rollbackFor = Exception.class)
    int productPicDelete(List<Integer> productPicsList);
}
