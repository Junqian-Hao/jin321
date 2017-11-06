package com.jin321.ms.model;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
public class TrueProduct {
    private Integer pid;

    private Integer did;

    private String pname;

    private String psummary;

    private Integer psellnum;

    private String ptypea;

    private String ptypeb;

    private Boolean isTogether;

    private Boolean isDelete;

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
        this.pname = pname;
    }

    public String getPsummary() {
        return psummary;
    }

    public void setPsummary(String psummary) {
        this.psummary = psummary;
    }

    public Integer getPsellnum() {
        return psellnum;
    }

    public void setPsellnum(Integer psellnum) {
        this.psellnum = psellnum;
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

    public Boolean getTogether() {
        return isTogether;
    }

    public void setTogether(Boolean together) {
        isTogether = together;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
