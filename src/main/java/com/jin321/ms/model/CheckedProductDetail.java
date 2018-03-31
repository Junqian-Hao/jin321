package com.jin321.ms.model;

import java.math.BigDecimal;

public class CheckedProductDetail {
    private int sid;

    private int pid;

    private int did;

    private String pname;

    private String dname;

    private String dphonenum;

    private String psummary;

    private BigDecimal pcost;

    private BigDecimal psoriprice;

    private BigDecimal pssellprice;

    private String ptypea;

    private String ptypeb;

    private String ptypec;

    private String sizename;

    private Integer snumber;


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDphonenum() {
        return dphonenum;
    }

    public void setDphonenum(String dphonenum) {
        this.dphonenum = dphonenum;
    }

    public String getPsummary() {
        return psummary;
    }

    public void setPsummary(String psummary) {
        this.psummary = psummary;
    }

    public BigDecimal getPcost() {
        return pcost;
    }

    public void setPcost(BigDecimal pcost) {
        this.pcost = pcost;
    }

    public BigDecimal getPsoriprice() {
        return psoriprice;
    }

    public void setPsoriprice(BigDecimal psoriprice) {
        this.psoriprice = psoriprice;
    }

    public BigDecimal getPssellprice() {
        return pssellprice;
    }

    public void setPssellprice(BigDecimal pssellprice) {
        this.pssellprice = pssellprice;
    }

    public String getPtypea() {
        return ptypea;
    }

    public void setPtypea(String ptypea) {
        this.ptypea = ptypea;
    }

    public String getPtypeb() {
        return ptypeb;
    }

    public void setPtypeb(String ptypeb) {
        this.ptypeb = ptypeb;
    }

    public String getPtypec() {
        return ptypec;
    }

    public void setPtypec(String ptypec) {
        this.ptypec = ptypec;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }
}
