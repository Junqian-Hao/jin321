package com.jin321.ms.Service;

import com.jin321.pl.model.Producttype;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tyranitarx on 2017/11/5.
 *
 * @Description :关于货物分类的接口
 */

public interface ProductTypeService {
    /**
     * 添加一级分类
     * @param producttype
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertFirstType(Producttype producttype);

    /**
     * 添加二级分类
     * @param producttype
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertSecondType(Producttype producttype);

    /**
     * 删除一级分类
     * @param tid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteFirstType(int tid);

    /**
     * 删除二级分类
     * @param tid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteSecondType(int tid);
}
