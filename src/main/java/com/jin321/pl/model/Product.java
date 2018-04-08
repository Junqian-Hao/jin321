package com.jin321.pl.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer pid;

    private Integer did;

    private String pname;

    private String psummary;

    private Integer psellnum;

    private Integer ptypea;

    private Integer ptypeb;

    private Integer ptypec;

    private Boolean isTogether;

    private Integer isDelete;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPsummary() {
        return psummary;
    }

    public void setPsummary(String psummary) {
        this.psummary = psummary == null ? null : psummary.trim();
    }

    public Integer getPsellnum() {
        return psellnum;
    }

    public void setPsellnum(Integer psellnum) {
        this.psellnum = psellnum;
    }

    public Integer getPtypea() {
        return ptypea;
    }

    public void setPtypea(Integer ptypea) {
        this.ptypea = ptypea;
    }

    public Integer getPtypeb() {
        return ptypeb;
    }

    public void setPtypeb(Integer ptypeb) {
        this.ptypeb = ptypeb;
    }

    public Integer getPtypec() {
        return ptypec;
    }

    public void setPtypec(Integer ptypec) {
        this.ptypec = ptypec;
    }

    public Boolean getIsTogether() {
        return isTogether;
    }

    public void setIsTogether(Boolean isTogether) {
        this.isTogether = isTogether;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}