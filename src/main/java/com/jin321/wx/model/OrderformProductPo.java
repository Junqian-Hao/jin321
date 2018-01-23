package com.jin321.wx.model;

import com.jin321.pl.model.Orderformproduct;

/**
 * @Author hao
 * @Date 2017/10/16 16:19
 * @Description :订单详情下
 */
public class OrderformProductPo extends Orderformproduct {
    private Integer pid;

    private Integer did;

    private String pname;

    private String psummary;

    private Integer psellnum;

    private Integer ptypea;

    private Integer ptypeb;

    private Integer ptypec;

    private Boolean isTogether;

    private Boolean isDelete;
    //商品缩略图
    private String ppicurl;
    //商家名字
    private String dname;

    @Override
    public Integer getPid() {
        return pid;
    }

    @Override
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

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}