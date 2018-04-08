package com.jin321.pl.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Productsize implements Serializable {
    private Integer sid;

    private Integer pid;

    private BigDecimal pscost;

    private BigDecimal psoriprice;

    private BigDecimal pssellprice;

    private String sizename;

    private Integer snumber;

    private Boolean isDeleted;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getPscost() {
        return pscost;
    }

    public void setPscost(BigDecimal pscost) {
        this.pscost = pscost;
    }

    public BigDecimal getPsoriprice() {
        return psoriprice;
    }

    public void setPsoriprice(BigDecimal psoriprice) {
        this.psoriprice = psoriprice;
    }

    public BigDecimal getPssellprice() {
        return pssellprice;
    }

    public void setPssellprice(BigDecimal pssellprice) {
        this.pssellprice = pssellprice;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename == null ? null : sizename.trim();
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}