package com.jin321.pl.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/27 22:37
 * @Description :
 */
public class StringUtilTest {
    @Test
    public void isNullString1() throws Exception {
    }


    @Test
    public void makeSession() throws Exception {
        String s = StringUtil.makeSession();
        System.out.println(s);
    }

    @Test
    public void isNullString() throws Exception {
        String string = "{\"openId\":\"oq7EC0ZDcSoX0BQ2o_OQB4bIMHCA\",\"nickName\":\"Uuu\",\"gender\":0,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"\",\"country\":\"\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/OicsDnyLWwAOpvWZ3jVgq5cbotPC7GgFD5zeIdztq82IoTgBz1Sz4WdwK688UUCPictDqDovaFEsfIeQLOAXeo0w/0\",\"watermark\":{\"timestamp\":1507710624,\"appid\":\"wxd390b42487afbe16\"}}";
        Map<String, String> map = JSONObject.parseObject(string, new TypeReference<Map<String, String>>() {});
        String openId = map.get("nickName");
        System.out.println(openId   );
    }

    @Test
    public void makeUserid() throws Exception {
        String lalalal = StringUtil.makeUserid();
        System.out.println(lalalal);
    }

}