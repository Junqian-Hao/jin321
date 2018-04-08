package com.jin321.pl.model;

import java.io.Serializable;

public class Chart implements Serializable {
    private Integer cartid;

    private String uid;

    private Integer pid;

    private Integer pnumber;

    private Integer sid;

    private Boolean isDeleted;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Chart{" +
                "cartid=" + cartid +
                ", uid='" + uid + '\'' +
                ", pid=" + pid +
                ", pnumber=" + pnumber +
                ", sid=" + sid +
                ", isDeleted=" + isDeleted +
                '}';
    }
}