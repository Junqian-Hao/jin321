package com.jin321.wx.utils;

import java.util.UUID;

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
        int i = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        String format = String.format(i+"%011d", hashCodeV);
        return Long.parseLong(format);
    }
}
