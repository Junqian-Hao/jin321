package com.jin321.wx.service;

import com.jin321.pl.model.District;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/8 20:54
 * @Description : 行政区划单位
 */
public interface DistrictService {
    /**
     * 查询下一级行政区划信息
     * @param cpaid 要查询的行政区id 全国为-1
     * @return
     * @throws Exception
     */
    List<District> selectNextDistrict(int cpaid) throws Exception;
}
