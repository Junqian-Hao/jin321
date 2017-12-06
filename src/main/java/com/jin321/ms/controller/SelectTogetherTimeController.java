package com.jin321.ms.controller;

import com.jin321.wx.service.FirstPageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/26 18:27
 * @Description :首页控制器
 */
@Controller
@RequestMapping("/ms")
public class SelectTogetherTimeController {
    private static final Log log = LogFactory.getLog(SelectTogetherTimeController.class);
    @Autowired
    FirstPageService firstPageService;
    /**
     * 首页信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/firstRequest")
    @ResponseBody
    public Map<String, Object> firstRequest(HttpServletRequest request) throws Exception {
        log.info("请求首页信息MS");
        Map<String, Object> firstPageMessage = firstPageService.getFirstPageMessage();
        firstPageMessage.put("basePath", "https://www.jin321.cn/jin321/");
        return firstPageMessage;
    }

}
