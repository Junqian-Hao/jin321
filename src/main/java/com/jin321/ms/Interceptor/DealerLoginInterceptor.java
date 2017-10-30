package com.jin321.ms.Interceptor;


import com.alibaba.fastjson.JSON;
import com.jin321.ms.controller.DealerLoginController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tyranitarx on 2017/10/16.
 *
 * @Description : 商家登录拦截器
 */
public class DealerLoginInterceptor implements HandlerInterceptor{
    private static final Log log = LogFactory.getLog(DealerLoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Map<String,String> returnMap=new HashMap<String, String>();
        String json;
        log.info("进入拦截器");
        if (!httpServletRequest.getRequestURI().contains("dealerLogin")&&!httpServletRequest.getRequestURI().contains("login.html")
                &&!httpServletRequest.getRequestURI().contains("Captcha")) {
            if(httpServletRequest.getSession().getAttribute("did")==null){
                httpServletResponse.setContentType("application/json; charset=utf-8");
                returnMap.put("code","-1");
                returnMap.put("msg","您尚未登录请登录");
                json= JSON.toJSONString(returnMap);
                httpServletResponse.getWriter().print(json);
                return false;
            }
            else
                return true;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
