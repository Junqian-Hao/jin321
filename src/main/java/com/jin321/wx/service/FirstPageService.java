package com.jin321.wx.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/26 17:01
 * @Description : 首页的业务逻辑
 */
public interface FirstPageService {

    /**
     * 商城请求首页，获得商城首页信息
     * @param userId 当前访问用户的id
     * @param lUserId 当前用户的推介人
     * @return 商城首页信息
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    Map<String, Object> getFirstPageMessage(String userId, String lUserId) throws Exception;

    /**
     * 微信登录
     * @param js_code
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    Map<String, String> login(String js_code , String lUserid) throws Exception;

}
