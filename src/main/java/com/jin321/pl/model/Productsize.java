package com.jin321.pl.model;

public class Productsize {
    private Integer sid;

    private Integer pid;

    private Long pscost;

    private Long psoriprice;

    private Long pssellprice;

    private String sizename;

    private Integer snumber;

    private Boolean isDeleted;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPscost() {
        return pscost;
    }

    public void setPscost(Long pscost) {
        this.pscost = pscost;
    }

    public Long getPsoriprice() {
        return psoriprice;
    }

    public void setPsoriprice(Long psoriprice) {
        this.psoriprice = psoriprice;
    }

    public Long getPssellprice() {
        return pssellprice;
    }

    public void setPssellprice(Long pssellprice) {
        this.pssellprice = pssellprice;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename == null ? null : sizename.trim();
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}