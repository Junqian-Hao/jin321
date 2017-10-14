package com.jin321.pl.model;

public class Productpics {
    private Integer ppid;

    private Integer pid;

    private String ppicurl;

    private Boolean isHeadpic;

    private Boolean isDeleted;

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl == null ? null : ppicurl.trim();
    }

    public Boolean getIsHeadpic() {
        return isHeadpic;
    }

    public void setIsHeadpic(Boolean isHeadpic) {
        this.isHeadpic = isHeadpic;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.Productpics{" +
                "ppid=" + ppid +
                ", pid=" + pid +
                ", ppicurl='" + ppicurl + '\'' +
                ", isHeadpic=" + isHeadpic +
                ", isDeleted=" + isDeleted +
                '}';
    }
}