package com.jin321.wx.model;

import com.jin321.pl.model.Product;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hao
 * @Date 2017/9/26 21:48
 * @Description : 超级货物接口
 */
public class SuperProduct extends Product implements Serializable {
    //    秒杀活动信息
    private Integer tpid;

    private Date timestart;

    private Date timeend;

    //缩略图信息
    private String ppicurl;

    //轮播活动信息
    private Integer rpid;

    private String rpicurl;


}
