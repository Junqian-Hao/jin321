package com.jin321.wx.model;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/23 17:34
 * @Description :
 */
public class DealerDetail {
    //经销商名字
    private String dname;
    private Integer did;
    //购物车商品
    private List<ChartDetail> chartDetails;

    public List<ChartDetail> getChartDetails() {
        return chartDetails;
    }

    public void setChartDetails(List<ChartDetail> chartDetails) {
        this.chartDetails = chartDetails;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
