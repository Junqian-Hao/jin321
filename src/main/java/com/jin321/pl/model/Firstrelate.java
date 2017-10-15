package com.jin321.pl.model;

public class Firstrelate {
    private Integer r1id;

    private String r1u1id;

    private String r1u2id;

    public Integer getR1id() {
        return r1id;
    }

    public void setR1id(Integer r1id) {
        this.r1id = r1id;
    }

    public String getR1u1id() {
        return r1u1id;
    }

    public void setR1u1id(String r1u1id) {
        this.r1u1id = r1u1id == null ? null : r1u1id.trim();
    }

    public String getR1u2id() {
        return r1u2id;
    }

    public void setR1u2id(String r1u2id) {
        this.r1u2id = r1u2id == null ? null : r1u2id.trim();
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Firstrelate{" +
                "r1id=" + r1id +
                ", r1u1id='" + r1u1id + '\'' +
                ", r1u2id='" + r1u2id + '\'' +
                '}';
    }
}