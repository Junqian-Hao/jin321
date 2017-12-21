package com.jin321.pl.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/25 12:56
 * @Description : 进行md5加密和接口加密算法
 */
public class Md5Util {
    private static final Log log = LogFactory.getLog(Md5Util.class);
    private static final String YAN = "jin321et";

    /**
     * 给指定字符串按照md5算法去加密
     *
     * @param psd 需要加密的密码	加盐处理
     * @return md5后的字符串
     */
    public static String Md5Encoder(String psd) {
        try {
            //加盐处理
//			psd = psd+"mobilesafe";
            //1,指定加密算法类型
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //2,将需要加密的字符串中转换成byte类型的数组,然后进行随机哈希过程
            byte[] bs = new byte[0];
            bs = digest.digest(psd.getBytes("utf-8"));
//			System.out.println(bs.length);
            //3,循环遍历bs,然后让其生成32位字符串,固定写法
            //4,拼接字符串过程
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bs) {
                int i = b & 0xff;
                //int类型的i需要转换成16机制字符
                String hexString = Integer.toHexString(i);
//				System.out.println(hexString);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            //5,打印测试
            log.info("md5加密结果：" + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param map 封装请求参数的map
     * @return 字典升序排列后的字符串md5加盐加密
     */
    public static String URLEncoder(Map<String, String> map) {
        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        String string = "";
        for (int i = 0; i < list.size(); i++) {
            log.info("key——值:" + list.get(i) + "," + map.get(list.get(i)));
            string += list.get(i) + map.get(list.get(i));
        }
        String secret = string;
        log.info("字典升序加密拼成字符串：" + secret + YAN);
        String encoder = Md5Util.Md5Encoder(secret + YAN);
        return encoder;
    }

}
