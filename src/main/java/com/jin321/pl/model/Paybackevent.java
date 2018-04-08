package com.jin321.pl.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Paybackevent implements Serializable {
    private Long eid;

    private Long oid;

    private Integer did;

    private BigDecimal backprice;

    private Integer eventstatus;

    private String messagedetail;

    private Boolean isDeleted;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public BigDecimal getBackprice() {
        return backprice;
    }

    public void setBackprice(BigDecimal backprice) {
        this.backprice = backprice;
    }

    public Integer getEventstatus() {
        return eventstatus;
    }

    public void setEventstatus(Integer eventstatus) {
        this.eventstatus = eventstatus;
    }

    public String getMessagedetail() {
        return messagedetail;
    }

    public void setMessagedetail(String messagedetail) {
        this.messagedetail = messagedetail == null ? null : messagedetail.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}