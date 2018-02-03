package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.Date;

public class Dealerbuyform {
    private Long dbfid;

    private Integer buyformstate;

    private BigDecimal totalmoney;

    private Date dbfdate;

    public Long getDbfid() {
        return dbfid;
    }

    public void setDbfid(Long dbfid) {
        this.dbfid = dbfid;
    }

    public Integer getBuyformstate() {
        return buyformstate;
    }

    public void setBuyformstate(Integer buyformstate) {
        this.buyformstate = buyformstate;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getDbfdate() {
        return dbfdate;
    }

    public void setDbfdate(Date dbfdate) {
        this.dbfdate = dbfdate;
    }
}