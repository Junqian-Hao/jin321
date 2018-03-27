package com.jin321.ms.model;

import java.math.BigDecimal;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :查询商品size详细接口
 */
public class UpdateProductSizeDetail {
    private int sid;

    private int pid;

    private String pname;

    private String psummary;

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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public String getPsummary() {
        return psummary;
    }

    public void setPsummary(String psummary) {
        this.psummary = psummary;
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
}
