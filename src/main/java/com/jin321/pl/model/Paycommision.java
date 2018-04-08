package com.jin321.pl.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Paycommision implements Serializable {
    private Integer pcid;

    private String uid;

    private BigDecimal paynum;

    private Date paydate;

    private String paymsg;

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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