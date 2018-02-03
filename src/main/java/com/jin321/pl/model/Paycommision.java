package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.Date;

public class Paycommision {
    private Integer pcid;

    private Integer uid;

    private BigDecimal paynum;

    private Date paydate;

    private String paymsg;

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getPaynum() {
        return paynum;
    }

    public void setPaynum(BigDecimal paynum) {
        this.paynum = paynum;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getPaymsg() {
        return paymsg;
    }

    public void setPaymsg(String paymsg) {
        this.paymsg = paymsg == null ? null : paymsg.trim();
    }
}