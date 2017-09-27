package com.jin321.pl.utils;

/**
 * @Author hao
 * @Date 2017/9/26 17:49
 * @Description : 字符串处理
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param s 需要判空的字符串
     * @return false 空 true 非空
     */
    public static boolean isNullString(String s) {
        if (s == null || s.length() <= 0) {

            return false;
        } else {
            return true;
        }
    }
}
