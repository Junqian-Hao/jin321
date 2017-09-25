package com.jin321.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    /**
     * 给指定字符串按照md5算法去加密
     * @param psd	需要加密的密码	加盐处理
     * @return		md5后的字符串
     */
    public static String Md5Encoder(String psd) {
        try {
            //加盐处理
//			psd = psd+"mobilesafe";
            //1,指定加密算法类型
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //2,将需要加密的字符串中转换成byte类型的数组,然后进行随机哈希过程
            byte[] bs = digest.digest(psd.getBytes());
//			System.out.println(bs.length);
            //3,循环遍历bs,然后让其生成32位字符串,固定写法
            //4,拼接字符串过程
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bs) {
                int i = b & 0xff;
                //int类型的i需要转换成16机制字符
                String hexString = Integer.toHexString(i);
//				System.out.println(hexString);
                if(hexString.length()<2){
                    hexString = "0"+hexString;
                }
                stringBuffer.append(hexString);
            }
            //5,打印测试
            System.out.println(stringBuffer.toString());
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
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
            System.out.println("key——值:"+list.get(i)+","+map.get(list.get(i)));
            string +=list.get(i)+map.get(list.get(i));
        }
//        String secret = string + Urls.FFA;
        String secret = string;
        System.out.println("拼成的参数为："+secret);
        String encoder = Md5Util.Md5Encoder(secret);
        return encoder;
    }
}
