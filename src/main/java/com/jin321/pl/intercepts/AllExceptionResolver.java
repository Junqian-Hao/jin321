package com.jin321.pl.intercepts;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author hao
 * @Date 2017/5/10 16:28
 * @Description : 全局异常处理
 */
public class AllExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        try {
            httpServletResponse.getOutputStream().print("{\"code\":\"-1\",\"errormessage\":\""+e.getMessage()+"\"}");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
