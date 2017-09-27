package com.jin321.wx.controller;

import com.jin321.pl.utils.UrlUtil;
import com.jin321.wx.service.FirstPageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/wx")
public class FirstPageController {
    private static final Log log = LogFactory.getLog(FirstPageController.class);
    @Autowired
    FirstPageService firstPageService;

    @RequestMapping("/firstRequest")
    @ResponseBody
    public Map<String, Object> firstRequest(HttpServletRequest request, @RequestBody Map<String, String> map) throws Exception {
        log.info("相对路径：" + UrlUtil.getPath(request));
        log.info("完整路径：" + UrlUtil.getBasePath(request));
        log.info("物理路径：" + UrlUtil.getRealPath(request));
        log.info("请求参数：userId->" + map.get("userId") + "lUserId->" + map.get("lUserId"));
        Map<String, Object> firstPageMessage = firstPageService.getFirstPageMessage(map.get("userId"), map.get("lUserId"));
        firstPageMessage.put("basePath", UrlUtil.getBasePath(request));
        return firstPageMessage;
    }

    public Map<String, Object> login()

}
