package com.jin321.wx.dao;

import com.jin321.wx.model.TimeproducDetail;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/26 17:35
 * @Description : 秒杀活动详细信息
 */
public interface TimeproducDetailMapper {
    List<TimeproducDetail> selectAll();
}
