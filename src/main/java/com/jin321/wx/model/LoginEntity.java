package com.jin321.wx.model;

/**
 * @Author hao
 * @Date 2017/9/27 22:08
 * @Description : 存储用户登录信息
 */
public class LoginEntity {
    String sessionKey;
    String openid;
    String userid;
    long tim;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public long getTim() {
        return tim;
    }

    public void setTim(long tim) {
        this.tim = tim;
    }

    @Override
    public String toString() {
        return "com.jin321.wx.model.LoginEntity{" +
                "sessionKey='" + sessionKey + '\'' +
                ", openid='" + openid + '\'' +
                ", userid='" + userid + '\'' +
                ", tim=" + tim +
                '}';
    }
}
