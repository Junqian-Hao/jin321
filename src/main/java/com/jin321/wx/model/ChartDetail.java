package com.jin321.wx.model;

import com.jin321.pl.model.Chart;

import java.math.BigDecimal;

/**
 * @Author hao
 * @Date 2017/9/27 16:33
 * @Description : 购物车
 */
public class ChartDetail extends Chart {
    //商品缩略图
    private String ppicurl;
    //原价
    private BigDecimal psoriprice;
    //售价
    private BigDecimal pssellprice;
    //规格名称
    private String sizename;
    //商品名字
    private String pname;

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "com.jin321.wx.model.ChartDetail{" +
                "ppicurl='" + ppicurl + '\'' +
                ", psoriprice=" + psoriprice +
                ", pssellprice=" + pssellprice +
                ", sizename='" + sizename + '\'' +
                "} " + super.toString();
    }
}
