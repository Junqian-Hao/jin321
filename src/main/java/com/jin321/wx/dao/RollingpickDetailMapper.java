package com.jin321.wx.dao;

import com.jin321.wx.model.RollingpickDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/26 17:24
 * @Description : 轮播图
 */
public interface RollingpickDetailMapper {
    RollingpickDetail selectNowByPid(@Param("pid")Integer pid);

    /**
     * 查询所有现在进行的轮播图活动
     * @return
     */
    List<RollingpickDetail> selectNow();
}
