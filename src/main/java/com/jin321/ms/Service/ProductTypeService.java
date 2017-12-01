package com.jin321.ms.Service;

import com.jin321.ms.model.TrueProductType;
import com.jin321.pl.model.Producttype;
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
     * 添加三级分类
     * @param producttype
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertThirtType(Producttype producttype);
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

    /**
     * 删除三级分类
     * @param tid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteThridType(int tid);
    /**
     * 获取一级一级二级三级分类
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<TrueProductType> getAllTypes();

    @Transactional(rollbackFor = Exception.class)
    public List<Producttype> getAllTypes1(int tid);
}
