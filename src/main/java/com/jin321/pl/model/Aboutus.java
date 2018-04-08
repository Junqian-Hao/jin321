package com.jin321.pl.model;

import java.io.Serializable;

public class Aboutus implements Serializable {
    private Integer auid;

    private String detail;

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}