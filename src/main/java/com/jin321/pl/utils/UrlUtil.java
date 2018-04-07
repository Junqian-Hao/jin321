package com.jin321.pl.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hao
 * @Date 2017/9/26 22:31
 * @Description :
 */
public class UrlUtil {
    public static final String win_basePath = "C:\\jin321pictures\\";
    public static final String win_productdetail = "C:\\jin321pictures\\productdetail\\";
    public static final String win_productpics = "C:\\jin321pictures\\productpics\\";
    public static final String win_productsecondtype = "C:\\jin321pictures\\productsecondtype\\";
    public static final String win_rollingpick = "C:\\jin321pictures\\rollingpick\\";
    public static final String linux_basePath = "/root/apache-tomcat-8.5.23/webapps/jin321/";
    public static final String linux_productdetail = "/root/apache-tomcat-8.5.23/webapps/jin321/productdetail/";
    public static final String linux_productpics = "/root/apache-tomcat-8.5.23/webapps/jin321/productpics/";
    public static final String linux_productsecondtype = "/root/apache-tomcat-8.5.23/webapps/jin321/productsecondtype/";
    public static final String linux_rollingpick = "/root/apache-tomcat-8.5.23/webapps/jin321/rollingpick/";
    public static final String linux_banner = "/root/apache-tomcat-8.5.23/webapps/jin321/banner/";
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
     * 返回当前项目的绝对路径不带端口
     * @param request
     * @return
     */
    public static String getBasePathNoPort(HttpServletRequest request) {
        return request.getScheme()+"://"+request.getServerName()+getPath(request)+"/";
    }

    /**
     * 返回当前项目的真实路径
     * @param request
     * @return
     */
    public static String getRealPath(HttpServletRequest request) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return win_basePath;
        } else {
            return linux_basePath;
        }
    }

}
