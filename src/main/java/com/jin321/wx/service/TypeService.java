package com.jin321.wx.service;

import com.jin321.pl.model.Producttype;
import com.jin321.wx.model.ProductPo;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/7 21:35
 * @Description :商品分类
 */
public interface TypeService {
    /**
     * 查询所有的一级标签
     * @return
     */
    List<Producttype> selectAllFirstProducttype() throws Exception;

    /**
     * 查询一级标签下属二级标签
     * @param tid
     * @return
     * @throws Exception
     */
    List<Producttype> selectSecondProducttype(int tid) throws Exception;


    /**
     * 通过二级标签id查询下属商品
     * @param ptypeb
     * @return
     * @throws Exception
     */
    List<ProductPo> selectProductByptypeb(int ptypeb,String code) throws Exception;
}
