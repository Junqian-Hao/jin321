package com.jin321.pl.utils;

import com.jin321.wx.model.LoginEntity;
import io.jsonwebtoken.Claims;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/17 17:05
 * @Description :
 */
public class JWTUtilTest {
    @Test
    public void parseJWT1() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangxin");
        map.put("age", "1");
        map.put("sex", "women");
        map.put("number", "asnkdas");
        String jwt = JWTUtil.createJWT(map,1);
        System.out.println(jwt);
        Claims claims = JWTUtil.parseJWT(jwt);
        System.out.println(claims);
    }

    @Test
    public void parseJWTToMap() throws Exception {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserid("sladasdasdsad");
        loginEntity.setOpenid("jsadfkdjfkl");
        loginEntity.setSessionKey("jfklsajkl");
        String jwt = JWTUtil.createJWTfromBean(loginEntity);
        System.out.println(jwt);
        Map<String, Object> map = JWTUtil.parseJWTToMap(jwt);
        System.out.println(map);
    }

    @Test
    public void parseJWTToBean() throws Exception {
    }

    @Test
    public void createJWT1() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangxin");
        map.put("age", "1");
        map.put("sex", "women");
        map.put("number", "asnkdas");
        String jwt = JWTUtil.createJWT(map);
        System.out.println(jwt);
    }

    @Test
    public void createJWT2() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangxin");
        map.put("age", "1");
        map.put("sex", "women");
        map.put("number", "asnkdas");
        String jwt = JWTUtil.createJWT(map,1);
        System.out.println(jwt);
    }

    @Test
    public void createJWT3() throws Exception {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserid("sladasdasdsad");
        loginEntity.setOpenid("jsadfkdjfkl");
        loginEntity.setSessionKey("jfklsajkl");
        String jwt = JWTUtil.createJWTfromBean(loginEntity);
        System.out.println(jwt);
    }

    @Test
    public void parseJWT() throws Exception {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserid("sladasdasdsad");
        loginEntity.setOpenid("jsadfkdjfkl");
        loginEntity.setSessionKey("jfklsajkl");
        String jwt = JWTUtil.createJWTfromBean(loginEntity);
        System.out.println(jwt);
        LoginEntity loginEntity1 = JWTUtil.parseJWTToBean(jwt, loginEntity);
        System.out.println(loginEntity);

    }

    @Test
    public void createJWT() throws Exception {

    }

}