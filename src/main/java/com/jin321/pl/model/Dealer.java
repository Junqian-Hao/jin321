package com.jin321.pl.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dealer implements Serializable {
    private Integer did;

    private String dname;

    private BigDecimal dearned;

    private String daddress;

    private String dphonenum;

    private String dusername;

    private String dpassword;

    private String dpower;

    private Boolean isDeleted;

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
        this.dname = dname == null ? null : dname.trim();
    }

    public BigDecimal getDearned() {
        return dearned;
    }

    public void setDearned(BigDecimal dearned) {
        this.dearned = dearned;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress == null ? null : daddress.trim();
    }

    public String getDphonenum() {
        return dphonenum;
    }

    public void setDphonenum(String dphonenum) {
        this.dphonenum = dphonenum == null ? null : dphonenum.trim();
    }

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername == null ? null : dusername.trim();
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword == null ? null : dpassword.trim();
    }

    public String getDpower() {
        return dpower;
    }

    public void setDpower(String dpower) {
        this.dpower = dpower == null ? null : dpower.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}