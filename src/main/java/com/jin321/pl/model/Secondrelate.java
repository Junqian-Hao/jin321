package com.jin321.pl.model;

import java.io.Serializable;

public class Secondrelate implements Serializable {
    private Integer r2id;

    private String r2u1id;

    private String r2u2id;

    public Integer getR2id() {
        return r2id;
    }

    public void setR2id(Integer r2id) {
        this.r2id = r2id;
    }

    public String getR2u1id() {
        return r2u1id;
    }

    public void setR2u1id(String r2u1id) {
        this.r2u1id = r2u1id == null ? null : r2u1id.trim();
    }

    public String getR2u2id() {
        return r2u2id;
    }

    public void setR2u2id(String r2u2id) {
        this.r2u2id = r2u2id == null ? null : r2u2id.trim();
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Secondrelate{" +
                "r2id=" + r2id +
                ", r2u1id='" + r2u1id + '\'' +
                ", r2u2id='" + r2u2id + '\'' +
                '}';
    }
}