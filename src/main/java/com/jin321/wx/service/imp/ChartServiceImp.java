package com.jin321.wx.service.imp;

import com.jin321.pl.dao.ChartMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Chart;
import com.jin321.pl.model.ChartExample;
import com.jin321.pl.model.Productsize;
import com.jin321.wx.dao.ChartDetailMapper;
import com.jin321.wx.model.DealerDetail;
import com.jin321.wx.service.ChartService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/5 22:09
 * @Description :购物车实现类
 */
@Service("chartService")
@Transactional(rollbackFor = Exception.class)
public class ChartServiceImp implements ChartService{
    private static final Log log = LogFactory.getLog(ChartServiceImp.class);
    @Autowired
    ChartMapper chartMapper;
    @Autowired
    ChartDetailMapper chartDetailMapper;
    @Autowired
    ProductsizeMapper productsizeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertChart(Chart chart) throws Exception {
        ChartExample chartExample = new ChartExample();
        ChartExample.Criteria criteria = chartExample.createCriteria();
        criteria.andUidEqualTo(chart.getUid());
        criteria.andSidEqualTo(chart.getSid());
        criteria.andSidEqualTo(chart.getSid());
        List<Chart> charts = chartMapper.selectByExample(chartExample);
        if (charts.size() > 0) {
            //购物车存在要添加的商品
            Chart chart1 = charts.get(0);
            Integer pnumber = chart1.getPnumber();
            chart1.setPnumber(pnumber+1);
            chartMapper.updateByPrimaryKeySelective(chart1);
            return true;
        }

        Productsize productsize = productsizeMapper.selectByPrimaryKey(chart.getSid());
        if (productsize.getSnumber() < chart.getPnumber()) {
            log.info("加入购物车商品数量超标");
            return false;
        }
        int i = chartMapper.insertSelective(chart);
        if (i > 0) {
            return true;
        }
        log.warn("购物车插入错误"+chart);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteChart(int cartid) throws Exception {
        int i = chartMapper.deleteByPrimaryKey(cartid);
        if (i > 0) {
            return true;
        }
        log.warn("购物车删除错误，chartid-》"+cartid);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateChartPnumber(int chart, int pnumber) throws Exception {
        Chart chart1 = chartMapper.selectByPrimaryKey(chart);
        if (chart1 == null) {
            log.info("更新购物车，购物车记录不存在，chartid-》"+chart);
            return false;
        }
        Productsize productsize = productsizeMapper.selectByPrimaryKey(chart1.getSid());
        if (productsize.getSnumber() < pnumber) {
            log.info("更新购物车,数量超标");
            return false;
        }
        chart1.setPnumber(pnumber);
        int i = chartMapper.updateByPrimaryKeySelective(chart1);
        if (i > 0) {
            return true;
        }
        log.warn("更新购物车，插入数据库失败");
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<DealerDetail> selectChartByUserId(String uid) throws Exception {
        List<DealerDetail> chartDetails = chartDetailMapper.selectChaetDetailByUid(uid);
        if (chartDetails.size() > 0) {
            return chartDetails;
        }
        return null;
    }
}
