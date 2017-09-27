package com.jin321.wx.model;

import com.jin321.pl.model.Product;

/**
 * @Author hao
 * @Date 2017/9/26 17:19
 * @Description : 秒杀活动详细信息
 */
public class RollingpickDetail extends Product{

    private Integer rpid;

    private String rpicurl;

//    缩略图信息
    private String ppicurl;

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }


    public String getRpicurl() {
        return rpicurl;
    }

    public void setRpicurl(String rpicurl) {
        this.rpicurl = rpicurl;
    }

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }
}
