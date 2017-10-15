package com.jin321.pl.model;

import java.math.BigDecimal;

public class Orderformproduct {
    private Integer ofpid;

    private Long oid;

    private Integer pid;

    private Integer sid;

    private Integer pamount;

    private BigDecimal pbuyprice;

    public Integer getOfpid() {
        return ofpid;
    }

    public void setOfpid(Integer ofpid) {
        this.ofpid = ofpid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPamount() {
        return pamount;
    }

    public void setPamount(Integer pamount) {
        this.pamount = pamount;
    }

    public BigDecimal getPbuyprice() {
        return pbuyprice;
    }

    public void setPbuyprice(BigDecimal pbuyprice) {
        this.pbuyprice = pbuyprice;
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Orderformproduct{" +
                "ofpid=" + ofpid +
                ", oid=" + oid +
                ", pid=" + pid +
                ", sid=" + sid +
                ", pamount=" + pamount +
                ", pbuyprice=" + pbuyprice +
                '}';
    }
}