package com.jin321.pl.model;

public class Producttype {
    private Integer tid;

    private String typename;

    private Integer typeclass;

    private Boolean isDelete;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getTypeclass() {
        return typeclass;
    }

    public void setTypeclass(Integer typeclass) {
        this.typeclass = typeclass;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}