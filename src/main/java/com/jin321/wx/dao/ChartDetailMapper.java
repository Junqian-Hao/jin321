package com.jin321.wx.dao;

import com.jin321.wx.model.ChartDetail;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/6 11:09
 * @Description :购物车扩展类
 */
public interface ChartDetailMapper {
    List<ChartDetail> selectChaetDetailByUid(String uid);
}
