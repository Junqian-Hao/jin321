package com.jin321.pl.utils;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : 退款提醒常量
 */
public class PayBackEventState {
    /**
     *  请求发出未处理
     */
    public static int REQUEST_PAYBACK = 0;
    /**
     *  接受退单
     */
    public static int PAYBACK_SUCCESS = 1;
    /**
     *  拒绝退单
     */
    public static int PAYBACK_REFUSE = 2;
}
