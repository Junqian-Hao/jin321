package com.jin321.pl.intercepts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    private static final Log log = LogFactory.getLog(AllExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        try {
            log.error("发生异常！！！！！！");
            log.error("详细消息字符串："+e.getMessage());
            log.error("本地化描述" + e.getLocalizedMessage());
            log.error("简短描述" + e.toString());
            log.error("堆栈信息",e);
            httpServletResponse.getOutputStream().print("{\"code\":\"-1\",\"errormessage\":\"" + e.getMessage() + "\"}");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
