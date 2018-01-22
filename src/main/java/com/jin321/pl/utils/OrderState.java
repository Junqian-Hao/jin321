package com.jin321.pl.utils;

/**
 * @Author hao
 * @Date 2017/10/11 14:22
 * @Description :订单状态常量
 */
public class OrderState {
    /**
     * 用户新下单，未支付
     */
    public static int PLACE_ORDER_NOTPAY = 0;
    /**
     * 用户下单已支付
     */
    public static int PLACE_ORDER_PAY = 1;
    /**
     * 商家发货
     */
    public static int MERCHANT_SHIPPING = 2;
    /**
     * 用户已签收
     */
    public static int SIGN_FOR_ORDER = 3;

    /**
     * 用户确认收货
     */
    public static int CONFIRM_AN_ORDER = 4;

    /**
     * 申请取消订单
     */
    public static int CANCELLATION_OF_ORDER = 5;

    /**
     * 商家确认取消订单
     */
    public static int CONFIRM_CANCELLATION_OF_ORDER = 6;

    /**
     * 用户删除订单
     */
    public static int USER_DELETION_ORDER = 7;
}
