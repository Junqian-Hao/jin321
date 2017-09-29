package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.Date;

public class Billtable {
    private Integer btid;

    private String uid;

    private Boolean btpayorback;

    private BigDecimal btmoney;

    private Date btimestamp;

    public Integer getBtid() {
        return btid;
    }

    public void setBtid(Integer btid) {
        this.btid = btid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Boolean getBtpayorback() {
        return btpayorback;
    }

    public void setBtpayorback(Boolean btpayorback) {
        this.btpayorback = btpayorback;
    }

    public BigDecimal getBtmoney() {
        return btmoney;
    }

    public void setBtmoney(BigDecimal btmoney) {
        this.btmoney = btmoney;
    }

    public Date getBtimestamp() {
        return btimestamp;
    }

    public void setBtimestamp(Date btimestamp) {
        this.btimestamp = btimestamp;
    }
}