package com.jin321.pl.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hao
 * @Date 2017/9/26 22:31
 * @Description :
 */
public class UrlUtil {
    /**
     * 返回当前项目的相对路径
     * @param request
     * @return
     */
    public static String getPath(HttpServletRequest request) {
        return request.getContextPath();
    }

    /**
     * 返回当前项目的绝对路径
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request) {
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+getPath(request)+"/";
    }

    /**
     * 返回当前项目的真实路径
     * @param request
     * @return
     */
    public static String getRealPath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }

}
