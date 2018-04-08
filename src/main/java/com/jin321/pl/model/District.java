package com.jin321.pl.model;

import java.io.Serializable;

public class District implements Serializable {
    private Integer cId;

    private Integer cPaId;

    private Byte cLevel;

    private String cName;

    private Double cLon;

    private Double cLat;

    private String cAlias;

    private String cSpell;

    private String cSzm;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getcPaId() {
        return cPaId;
    }

    public void setcPaId(Integer cPaId) {
        this.cPaId = cPaId;
    }

    public Byte getcLevel() {
        return cLevel;
    }

    public void setcLevel(Byte cLevel) {
        this.cLevel = cLevel;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Double getcLon() {
        return cLon;
    }

    public void setcLon(Double cLon) {
        this.cLon = cLon;
    }

    public Double getcLat() {
        return cLat;
    }

    public void setcLat(Double cLat) {
        this.cLat = cLat;
    }

    public String getcAlias() {
        return cAlias;
    }

    public void setcAlias(String cAlias) {
        this.cAlias = cAlias == null ? null : cAlias.trim();
    }

    public String getcSpell() {
        return cSpell;
    }

    public void setcSpell(String cSpell) {
        this.cSpell = cSpell == null ? null : cSpell.trim();
    }

    public String getcSzm() {
        return cSzm;
    }

    public void setcSzm(String cSzm) {
        this.cSzm = cSzm == null ? null : cSzm.trim();
    }

    @Override
    public String toString() {
        return "com.jin321.pl.model.District{" +
                "cId=" + cId +
                ", cPaId=" + cPaId +
                ", cLevel=" + cLevel +
                ", cName='" + cName + '\'' +
                ", cLon=" + cLon +
                ", cLat=" + cLat +
                ", cAlias='" + cAlias + '\'' +
                ", cSpell='" + cSpell + '\'' +
                ", cSzm='" + cSzm + '\'' +
                '}';
    }
}