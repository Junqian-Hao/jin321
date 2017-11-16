package com.jin321.wx.controller;

import com.jin321.pl.model.Useraddress;
import com.jin321.wx.service.UseraddressService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/10 18:54
 * @Description :用户收货地址
 */
@Controller
@RequestMapping("/wx")
public class UseraddressController {
    private static final Log log = LogFactory.getLog(UseraddressController.class);
    @Autowired
    UseraddressService useraddressService;

    /**
     * 添加用户收货地址
     * @param useraddress
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertUseraddress")
    @ResponseBody
    public Map<String, Object> insertUseraddress(@RequestBody Useraddress useraddress, HttpServletRequest request) throws Exception {
        log.info("添加用户收货地址->"+useraddress);
        HashMap<String, Object> map = new HashMap<String, Object>();
        boolean b = useraddressService.insertUseraddress(useraddress);
        if (b) {
            map.put("code", 1);
            map.put("message", "插入成功");
        } else {
            map.put("code", 0);
            map.put("message", "插入失败");
        }
        return map;
    }

    /**
     * 根据uaid删除用户收货地址
     * @param re
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteUseraddressByid")
    @ResponseBody
    public Map<String, Object> deleteUseraddressByid(@RequestBody Map<String, String> re, HttpServletRequest request) throws Exception {
        log.info("根据uaid删除用户收货地址->"+re.get("uaid"));
        String uaid = re.get("uaid");
        HashMap<String, Object> map = new HashMap<String, Object>();
        boolean b = useraddressService.deleteUseraddressByid(Integer.parseInt(uaid));
        if (b) {
            map.put("code", 1);
            map.put("message", "删除成功");
        } else {
            map.put("code", 0);
            map.put("message", "删除失败");
        }
        return map;
    }

    /**
     * 根据uaid更新收货地址
     * @param useraddress
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUseraddressByid")
    @ResponseBody
    public Map<String, Object> updateUseraddressByid(@RequestBody Useraddress useraddress, HttpServletRequest request) throws Exception {
        log.info("根据uaid更新收货地址->"+useraddress);
        HashMap<String, Object> map = new HashMap<String, Object>();
        boolean b = useraddressService.updateUseraddressByid(useraddress);
        if (b) {
            map.put("code", 1);
            map.put("message", "修改成功");
        } else {
            map.put("code", 0);
            map.put("message", "修改失败");
        }
        return map;
    }

    /**
     * 根据uid查询收货地址
     * @param re
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectUseraddressByuid")
    @ResponseBody
    public Map<String, Object> selectUseraddressByuid(@RequestBody Map<String, String> re, HttpServletRequest request) throws Exception {
        log.info("根据uid查询收货地址->"+re.get("uid"));
        String uid = re.get("uid");
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Useraddress> useraddresses = useraddressService.selectUseraddressByuid(uid);
        if (useraddresses != null && useraddresses.size() > 0) {
            map.put("code", 1);
            map.put("useraddresses", useraddresses);
        } else {
            map.put("code", 0);
            map.put("message", "未查询到");
        }
        return map;
    }
}
