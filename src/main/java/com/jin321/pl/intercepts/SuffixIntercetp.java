package com.jin321.pl.intercepts;

import com.jin321.pl.utils.Md5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理*.do后缀的拦截器
 * @Author hao
 * @Date 2017/9/26 13:21
 * @Description :
 */
public class SuffixIntercetp implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(SuffixIntercetp.class);


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.contains(".do")) {
            String replace = requestURI.substring(0, requestURI.lastIndexOf("."));
//            replace = replace.replace("/jin321", "");
            log.debug("请求URL：" + requestURI);
            log.debug("截取后URL：" + replace);
            httpServletRequest.getRequestDispatcher(replace).forward(httpServletRequest, httpServletResponse);
            return false;
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
