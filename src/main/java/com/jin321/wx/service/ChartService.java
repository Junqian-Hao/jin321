package com.jin321.wx.service;

import com.jin321.pl.model.Chart;
import com.jin321.wx.model.DealerDetail;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/5 20:55
 * @Description :购物车业务逻辑
 */
public interface ChartService {
    /**
     * 添加购物车
     *
     * @param chart
     * @return
     */
    boolean insertChart(Chart chart) throws Exception;

    /**
     * 删除购物车信息
     * @param chartid
     * @return
     * @throws Exception
     */
    boolean deleteChart(int chartid) throws Exception;

    /**
     * 更新购物车商品数量
     * @param chart
     * @param pnumber
     * @return
     */
    boolean updateChartPnumber(int chart, int pnumber) throws Exception;

    /**
     * 查询购物车商品信息
     * @param uid
     * @return
     * @throws Exception
     */
    List<DealerDetail> selectChartByUserId(String uid) throws Exception;
}
