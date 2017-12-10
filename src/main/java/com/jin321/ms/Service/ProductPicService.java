package com.jin321.ms.Service;

import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productpics;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
     * 添加头图
     * @param productpics
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int productHeadPicService(Productpics productpics);

    /**
     * 删除图片缩略图
     * @param
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    void productNoHeadPicDelete(int pid, Boolean header);

    /**
     * 删除图片
     * @param productpicsList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int productPicDelete(List<Integer> productpicsList);
    /**
     * 查看当前缩略图
     */
    @Transactional(rollbackFor = Exception.class)
    List<Productpics> selectProductPicNow(int pid);
}
