package com.jin321.wx.dao;

import com.jin321.pl.model.Productpics;

/**
 * @Author hao
 * @Date 2017/9/28 13:42
 * @Description :货物相关图片的逻辑
 */
public interface ProductpicsDetailMapper {
    Productpics selectNowHeadPicByPid(String pid);

}
