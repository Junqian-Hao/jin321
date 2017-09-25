package com.jin321.pl.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/25 23:56
 * @Description :
 */
public class Md5UtilTest {
    @Test
    public void md5Encoder() throws Exception {
        String jin321 = Md5Util.Md5Encoder("jin321");
        System.out.println(jin321);

    }

    @Test
    public void URLEncoder() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", "123");
        map.put("password", "123abc");
        String s = Md5Util.URLEncoder(map);
        System.out.println(s);
    }

}