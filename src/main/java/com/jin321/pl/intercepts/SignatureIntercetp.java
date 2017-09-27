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
 * 接口签名认证拦截器
 * @Author hao
 * @Date 2017/9/26 13:21
 * @Description :
 */
public class SignatureIntercetp implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(SignatureIntercetp.class);


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String sign = httpServletRequest.getParameter("sign");
        if (sign == null || "".equals(sign.trim())) {
            log.info(httpServletRequest.getRemoteAddr()+"未携带签名访问，签名拦截器拦截！！");
            try {
                httpServletResponse.getOutputStream().print("{\"code\":\"-1\",\"errormessage\":\"未携带签名\"}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        Map<String, String> map = new HashMap<String, String>();
//        处理请求参数
        while (parameterNames.hasMoreElements()) {
            if ("sign".equals(parameterNames.nextElement())) {
                break;
            }
            map.put(parameterNames.nextElement(), httpServletRequest.getParameter(parameterNames.nextElement()));
        }

        if (Md5Util.URLEncoder(map).equals(sign)) {
            log.info(httpServletRequest.getRemoteAddr()+"访问，签名正确，放行");
            return true;
        }
        try {
            httpServletResponse.getOutputStream().print("{\"code\":\"-1\",\"errormessage\":\"签名错误\"}");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        log.info(httpServletRequest.getRemoteAddr()+"访问，签名错误，拦截！！");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
