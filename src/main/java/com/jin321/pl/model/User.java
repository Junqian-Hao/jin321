package com.jin321.pl.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String uid;

    private String userwxid;

    private Float ucommition;

    private Boolean isTogether;

    private Date registdate;

    private Date togetherdate;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUserwxid() {
        return userwxid;
    }

    public void setUserwxid(String userwxid) {
        this.userwxid = userwxid == null ? null : userwxid.trim();
    }

    public Float getUcommition() {
        return ucommition;
    }

    public void setUcommition(Float ucommition) {
        this.ucommition = ucommition;
    }

    public Boolean getIsTogether() {
        return isTogether;
    }

    public void setIsTogether(Boolean isTogether) {
        this.isTogether = isTogether;
    }

    public Date getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Date registdate) {
        this.registdate = registdate;
    }

    public Date getTogetherdate() {
        return togetherdate;
    }

    public void setTogetherdate(Date togetherdate) {
        this.togetherdate = togetherdate;
    }
}