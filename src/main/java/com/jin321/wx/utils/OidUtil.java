package com.jin321.wx.utils;

import java.util.Random;

/**
 * @Author hao
 * @Date 2017/10/11 15:18
 * @Description :
 */
public class OidUtil {
    /**
     * @return 获得新的订单编号
     */
    public static long newOid() {
        return Long.parseLong(System.currentTimeMillis() + "" + new Random().nextInt(9) + "" + new Random().nextInt(9) +""+ new Random().nextInt(9));
    }
}
