package com.jin321.ms.model;


import java.math.BigDecimal;
import java.util.Date;

public class DealerSellProductDetail {
    private int ofpid;
    private Long oid;
    private Long dbfid;
    private String pname;
    private String sizename;
    private BigDecimal pbuyprice;
    private int pamount;
    private Date odate;
    private Date opaydate;
    private Date osenddate;
    private Date oconfirmdate;

    public int getOfpid() {
        return ofpid;
    }

    public void setOfpid(int ofpid) {
        this.ofpid = ofpid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getDbfid() {
        return dbfid;
    }

    public void setDbfid(Long dbfid) {
        this.dbfid = dbfid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    public BigDecimal getPbuyprice() {
        return pbuyprice;
    }

    public void setPbuyprice(BigDecimal pbuyprice) {
        this.pbuyprice = pbuyprice;
    }

    public int getPamount() {
        return pamount;
    }

    public void setPamount(int pamount) {
        this.pamount = pamount;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Date getOpaydate() {
        return opaydate;
    }

    public void setOpaydate(Date opaydate) {
        this.opaydate = opaydate;
    }

    public Date getOsenddate() {
        return osenddate;
    }

    public void setOsenddate(Date osenddate) {
        this.osenddate = osenddate;
    }

    public Date getOconfirmdate() {
        return oconfirmdate;
    }

    public void setOconfirmdate(Date oconfirmdate) {
        this.oconfirmdate = oconfirmdate;
    }
}
