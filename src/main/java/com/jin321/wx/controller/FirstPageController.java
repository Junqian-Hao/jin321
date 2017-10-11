package com.jin321.wx.controller;

import com.jin321.pl.utils.StringUtil;
import com.jin321.pl.utils.UrlUtil;
import com.jin321.wx.model.LoginEntity;
import com.jin321.wx.service.FirstPageService;
import com.jin321.wx.utils.AES;
import org.apache.commons.codec.binary.Base64;
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


    /**
     * 首页信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/firstRequest")
    @ResponseBody
    public Map<String, Object> firstRequest(HttpServletRequest request) throws Exception {
        log.info("请求首页信息");
        Map<String, Object> firstPageMessage = firstPageService.getFirstPageMessage();
        firstPageMessage.put("basePath", UrlUtil.getBasePathNoPort(request));
        return firstPageMessage;
    }

    /**
     * 登录
     * @param request
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request, @RequestBody Map<String, String> re) throws Exception {
        log.info("进行登录操作");
        ServletContext servletContext = request.getServletContext();

        String js_code = re.get("js_code");
        String lUserid = re.get("lUserid");
        String session = re.get("session");
        log.info("请求的参数"+"js_code->"+js_code+"lUserid->"+lUserid+"session->"+session);

        if (!StringUtil.isNullString(session)) {
            //不是第一次登录是验证请求
            log.info("不是第一次登录是验证请求");
            LoginEntity loginEntity = (LoginEntity) servletContext.getAttribute(session);
            log.info("取出的loginEntity-》"+loginEntity);

            if ((loginEntity != null)&&(loginEntity.getTim() > (System.currentTimeMillis() - 240000))) {
                log.info("session未过期");
                //session未过期
                HashMap<String, String> map = new HashMap<String, String>();
                String openid = loginEntity.getOpenid();
                String userid = loginEntity.getUserid();
                map.put("code", "3");
                map.put("openid", openid);
                map.put("userid", userid);
                return map;
            } else {
                //session过期
                log.info("session过期");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("code", "4");
                map.put("message", "session过期");
                return map;
            }
        }
        Map<String, String> login = firstPageService.login(js_code, lUserid);
        String openid = login.get("openid");
        String session_key = login.get("session_key");
        String userid = login.get("userid");

        if (!StringUtil.isNullString(openid)&&!StringUtil.isNullString(session_key)) {
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setTim(System.currentTimeMillis());
            loginEntity.setSessionKey(session_key);
            loginEntity.setOpenid(openid);
            loginEntity.setUserid(userid);

            login.remove("session_key");
            String s = StringUtil.makeSession();
            login.put("session", s);

            //存入session
            servletContext.setAttribute(s, loginEntity);
        }
        return login;
    }

    /**
     * 解密用户数据
     * @param request
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserMessage")
    @ResponseBody
    public Map<String, Object> getUserMessage(HttpServletRequest request, @RequestBody Map<String, String> re) throws Exception {
        ServletContext servletContext = request.getServletContext();
        log.info("解码用户信息请求");
        HashMap<String, Object> map = new HashMap<String, Object>();
        String session = re.get("session");
        String encryptedData = re.get("encryptedData");
        String iv = re.get("iv");
        log.info("请求的session-》"+session);
        log.info("encryptedData数据-》"+encryptedData);
        log.info("iv-》" + iv);
        //获取session信息
        LoginEntity loginEntity = (LoginEntity) servletContext.getAttribute(session);
        log.info("取出的loginEntity-》"+loginEntity);
        if ((loginEntity != null) && (loginEntity.getTim() > (System.currentTimeMillis() - 2592000000l))) {
            log.info("session存在且未过期");
            String sessionKey = loginEntity.getSessionKey();
            log.info("sessionKey-》"+sessionKey);
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                String userInfo = new String(resultByte, "UTF-8");
                log.info("解密后的数据-》"+userInfo);
                map.put("code", 1);
                    map.put("userinfo", userInfo);
                return map;
            } else {
                log.info("解密失败");
                map.put("code", 0);
                map.put("message", "解密失败");
            }
            return map;
        } else {
            map.put("cade", 0);
            map.put("message", "session不存在或者已过期");
        }
        return map;
    }

}
