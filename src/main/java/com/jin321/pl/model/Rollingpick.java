package com.jin321.pl.model;

public class Rollingpick {
    private Integer rpid;

    private Integer pid;

    private String rpicurl;

    private Boolean isDeleted;

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getRpicurl() {
        return rpicurl;
    }

    public void setRpicurl(String rpicurl) {
        this.rpicurl = rpicurl == null ? null : rpicurl.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}