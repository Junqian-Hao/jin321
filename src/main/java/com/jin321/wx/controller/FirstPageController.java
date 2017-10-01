package com.jin321.wx.controller;

import com.jin321.pl.utils.StringUtil;
import com.jin321.pl.utils.UrlUtil;
import com.jin321.wx.model.LoginEntity;
import com.jin321.wx.service.FirstPageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    public Map<String, Object> firstRequest(HttpServletRequest request) throws Exception {
        log.info("相对路径：" + UrlUtil.getPath(request));
        log.info("完整路径：" + UrlUtil.getBasePath(request));
        log.info("物理路径：" + UrlUtil.getRealPath(request));
        Map<String, Object> firstPageMessage = firstPageService.getFirstPageMessage();
        firstPageMessage.put("basePath", UrlUtil.getBasePathNoPort(request));
        return firstPageMessage;
    }
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request, @RequestBody Map<String, String> re) throws Exception {
        ServletContext servletContext = request.getServletContext();

        String js_code = re.get("js_code");
        String lUserid = re.get("lUserid");
        String session = re.get("session");
        log.info("请求的参数"+"js_code->"+js_code+"lUserid->"+lUserid+"session->"+session);
        if (StringUtil.isNullString(js_code)) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", "0");
            map.put("message", "需要js_code");
            return map;
        }
        if (!StringUtil.isNullString(session)) {
        //不是第一次登录是验证请求
            LoginEntity loginEntity = (LoginEntity) servletContext.getAttribute(session);
            if ((loginEntity != null) && (loginEntity.getTim() > (System.currentTimeMillis() - (30 * 24 * 60 * 60 * 1000)))) {
//               //session未过期
                HashMap<String, String> map = new HashMap<String, String>();
                String openid = loginEntity.getOpenid();
                map.put("code", "0");
                map.put("openid", openid);
                return map;
            }
        }
        Map<String, String> login = firstPageService.login(js_code, lUserid);
        String openid = login.get("openid");
        String session_key = login.get("session_key");

        if (!StringUtil.isNullString(openid)&&!StringUtil.isNullString(session_key)) {
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setTim(System.currentTimeMillis());
            loginEntity.setSessionKey(session_key);
            loginEntity.setOpenid(openid);

            login.remove("session_key");
            String s = StringUtil.makeSession();
            login.put("session", s);

            //存入session
            servletContext.setAttribute(s, loginEntity);
        }
        return login;
    }

}
