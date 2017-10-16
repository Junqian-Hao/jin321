package com.jin321.wx.utils
/**
 * @Author hao
 * @Date 2017/10/15 16:56
 * @Description :
 */
class OidUtilTest extends GroovyTestCase {
    void testNewOid() {
        for (int i = 0; i < 100; i++) {
            long a = OidUtil.newOid();
            System.out.println(a)
        }
    }
}
