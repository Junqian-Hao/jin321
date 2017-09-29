package com.jin321.pl.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Author hao
 * @Date 2017/9/26 17:49
 * @Description : 字符串处理
 */
public class StringUtil {
    //appid
    public static String APPID = "appid";
    //secret
    public static String SECRET = "secret";

    /**
     * 判断字符串是否为空
     *
     * @param s 需要判空的字符串
     * @return false 非空 true 空
     */
    public static boolean isNullString(String s) {
        if (s == null || s.length() <= 0) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成userid
     *
     * @return 生成的微信id
     */
    public static String makeUserid() {
        return System.currentTimeMillis() + new Random().nextInt() + "";
    }

    /**
     * 生成session
     *
     * @return 生成的session
     */
    public static String makeSession() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
