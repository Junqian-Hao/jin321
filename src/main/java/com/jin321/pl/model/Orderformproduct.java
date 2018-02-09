package com.jin321.pl.model;

import java.math.BigDecimal;

public class Orderformproduct {
    private Integer ofpid;

    private Long oid;

    private Long dbfid;

    private Integer pid;

    private Integer sid;

    private Integer pamount;

    private BigDecimal pbuyprice;

    private Integer status;

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

    public Long getDbfid() {
        return dbfid;
    }

    public void setDbfid(Long dbfid) {
        this.dbfid = dbfid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}