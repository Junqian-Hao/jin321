package com.jin321.wx.model;

import com.jin321.pl.model.Product;

import java.util.Date;

/**
 * @Author hao
 * @Date 2017/9/26 17:34
 * @Description :
 */
public class TimeproducDetail extends Product {
//    秒杀活动信息
    private Integer tpid;

    private Date timestart;

    private Date timeend;

//缩略图信息
    private String ppicurl;



    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }


    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }
}
