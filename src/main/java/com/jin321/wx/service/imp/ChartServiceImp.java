package com.jin321.wx.service.imp;

import com.jin321.pl.dao.ChartMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Chart;
import com.jin321.pl.model.Productsize;
import com.jin321.wx.dao.ChartDetailMapper;
import com.jin321.wx.model.ChartDetail;
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
        Productsize productsize = productsizeMapper.selectByPrimaryKey(chart.getSid());
        if (productsize.getSnumber() < chart.getPnumber()) {
            log.info("加入购物车商品数量超标");
            return false;
        }
        int i = chartMapper.insertSelective(chart);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteChart(int chartid) throws Exception {
        int i = chartMapper.deleteByPrimaryKey(chartid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateChartPnumber(int chart, int pnumber) throws Exception {
        Chart chart1 = chartMapper.selectByPrimaryKey(chart);
        if (chart1 == null) {
            return false;
        }
        Productsize productsize = productsizeMapper.selectByPrimaryKey(chart1.getSid());
        if (productsize.getSnumber() < pnumber) {
            return false;
        }
        chart1.setPnumber(pnumber);
        int i = chartMapper.updateByPrimaryKeySelective(chart1);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ChartDetail> selectChartByUserId(String uid) throws Exception {
        List<ChartDetail> chartDetails = chartDetailMapper.selectChaetDetailByUid(uid);
        if (chartDetails.size() > 0) {
            return chartDetails;
        }
        return null;
    }
}
