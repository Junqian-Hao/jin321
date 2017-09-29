package com.jin321.pl.model;

public class User {
    private String uid;

    private String userwxid;

    private Float ucommition;

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
}