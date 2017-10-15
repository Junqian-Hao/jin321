package com.jin321.wx.utils;

import org.junit.Test;

/**
 * @Author hao
 * @Date 2017/10/11 15:57
 * @Description :
 */
public class OidUtilTest {
    @Test
    public void newOid() throws Exception {

        for (int j = 0; j < 1000; j++) {
            long i = OidUtil.newOid();
            System.out.println(i);
        }
    }

}