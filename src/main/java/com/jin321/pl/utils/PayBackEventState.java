package com.jin321.pl.utils;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : 退款提醒常量
 */
public class PayBackEventState {
    /**
     *  部分退单请求发出未处理
     */
    public static int REQUEST_PARTPAYBACK = 0;
    /**
     *  全部退单请求处理
     */
    public static int REQUEST_ALLPAYBACK = 1;
    /**
     *  部分退单请求发出处理
     */
    public static int PARTPAYBACK_SUCCESS = 2;
    /**
     *
     */
    public static int PARTPAYBACK_REFUSE = 2;
    /**
     *
     */
    public static int ALLPAYBACK_SUCCESS = 2;
    /**
     *
     */
    public static int ALLPAYBACK_REFUSE = 2;
}
