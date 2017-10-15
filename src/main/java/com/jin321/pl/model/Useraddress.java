package com.jin321.pl.model;

import java.util.Date;

public class Useraddress {
    private Integer uaid;

    private String uid;

    private String ucountry;

    private String uprovince;

    private String ucity;

    private String uarea;

    private String uaddress;

    private String ubname;

    private String uphonenum;

    private String umail;

    private Date addtime;

    private Boolean adddefault;

    private Boolean isDeleted;

    public Integer getUaid() {
        return uaid;
    }

    public void setUaid(Integer uaid) {
        this.uaid = uaid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUcountry() {
        return ucountry;
    }

    public void setUcountry(String ucountry) {
        this.ucountry = ucountry == null ? null : ucountry.trim();
    }

    public String getUprovince() {
        return uprovince;
    }

    public void setUprovince(String uprovince) {
        this.uprovince = uprovince == null ? null : uprovince.trim();
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity == null ? null : ucity.trim();
    }

    public String getUarea() {
        return uarea;
    }

    public void setUarea(String uarea) {
        this.uarea = uarea == null ? null : uarea.trim();
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress == null ? null : uaddress.trim();
    }

    public String getUbname() {
        return ubname;
    }

    public void setUbname(String ubname) {
        this.ubname = ubname == null ? null : ubname.trim();
    }

    public String getUphonenum() {
        return uphonenum;
    }

    public void setUphonenum(String uphonenum) {
        this.uphonenum = uphonenum == null ? null : uphonenum.trim();
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail == null ? null : umail.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getAdddefault() {
        return adddefault;
    }

    public void setAdddefault(Boolean adddefault) {
        this.adddefault = adddefault;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Useraddress{" +
                "uaid=" + uaid +
                ", uid='" + uid + '\'' +
                ", ucountry='" + ucountry + '\'' +
                ", uprovince='" + uprovince + '\'' +
                ", ucity='" + ucity + '\'' +
                ", uarea='" + uarea + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", ubname='" + ubname + '\'' +
                ", uphonenum='" + uphonenum + '\'' +
                ", umail='" + umail + '\'' +
                ", addtime=" + addtime +
                ", adddefault=" + adddefault +
                ", isDeleted=" + isDeleted +
                '}';
    }
}