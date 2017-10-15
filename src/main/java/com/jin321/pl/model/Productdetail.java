package com.jin321.pl.model;

public class Productdetail {
    private Integer pdid;

    private Integer pid;

    private String picurl;

    private Integer porder;

    private Boolean isDeleted;

    public Integer getPdid() {
        return pdid;
    }

    public void setPdid(Integer pdid) {
        this.pdid = pdid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public Integer getPorder() {
        return porder;
    }

    public void setPorder(Integer porder) {
        this.porder = porder;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Productdetail{" +
                "pdid=" + pdid +
                ", pid=" + pid +
                ", picurl='" + picurl + '\'' +
                ", porder=" + porder +
                ", isDeleted=" + isDeleted +
                '}';
    }
}