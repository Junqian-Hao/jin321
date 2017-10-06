package com.jin321.wx.model;

import com.jin321.pl.model.Chart;

/**
 * @Author hao
 * @Date 2017/9/27 16:33
 * @Description : 购物车
 */
public class ChartDetail extends Chart {
    //商品缩略图
    private String ppicurl;
    //原价
    private Long psoriprice;
    //售价
    private Long pssellprice;
    //规格名称
    private String sizename;

    public String getPpicurl() {
        return ppicurl;
    }

    public void setPpicurl(String ppicurl) {
        this.ppicurl = ppicurl;
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
        this.sizename = sizename;
    }
}
