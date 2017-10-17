package com.jin321.pl.utils;

import io.jsonwebtoken.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author hao
 * @Date 2017/10/17 16:54
 * @Description :json web token工具类
 */
public class JWTUtil {
    private static final Log log = LogFactory.getLog(JWTUtil.class);
    //jwt秘钥
    public static String jwt_key = "zhangxinzhenniubi";

    /**
     * 解码jwt
     *
     * @param jsonWebToken jwt密文
     * @return 参数集合claims 直接用get方法获取
     */
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(jwt_key))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            log.warn("密文过期或无效"+jsonWebToken);
            return null;
        }
    }

    /**
     * 解码token为map
     * @param jsonWebToken
     * @return
     */
    public static Map<String, Object> parseJWTToMap(String jsonWebToken) {
        Claims claims = parseJWT(jsonWebToken);
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> strings = claims.keySet();
        for (String key : strings) {
            Object s = claims.get(key);
            map.put(key, s);
        }
        return map;
    }

    /**
     * 解码token为map
     * @param jsonWebToken
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T parseJWTToBean(String jsonWebToken,T bean) {
        Map<String, Object> map = parseJWTToMap(jsonWebToken);
        T t = BeanMapUtil.mapToBean(map, bean);
        return t;
    }


    /**
     * 生成token
     * @param map token中携带的参数，解码后从Claims中获得
     * @param TTLMillis
     * @return
     */
    public static String createJWT(Map<String, Object> map, long TTLMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwt_key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT");
        //添加参数
        Set<String> strings = map.keySet();
        //如果超过3个参数就进行压缩
        if (strings.size() > 3) {
            builder.compressWith(CompressionCodecs.DEFLATE);
        }
        //遍历参数
        for (Object key : strings) {
            Object value = map.get(key);
            builder.claim(String.valueOf(key), value);
        }
        builder.signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    /**
     *  生成token，默认三天过期
     * @param map 参数
     * @return
     */
    public static String createJWT(Map<String, Object> map) {

        return createJWT(map,259200000);
    }

    /**
     * 生成token，默认三天过期
     * @param bean token携带的参数
     * @param <T>
     * @return
     */
    public static <T> String createJWTfromBean(T bean){
        Map<String, Object> map = BeanMapUtil.beanToMap(bean);
        return createJWT(map);
    }

}
