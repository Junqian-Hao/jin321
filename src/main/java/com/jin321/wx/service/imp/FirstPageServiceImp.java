package com.jin321.wx.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jin321.pl.dao.FirstrelateMapper;
import com.jin321.pl.dao.UserMapper;
import com.jin321.pl.model.Firstrelate;
import com.jin321.pl.model.User;
import com.jin321.pl.model.UserExample;
import com.jin321.pl.utils.StringUtil;
import com.jin321.wx.dao.ProductPoMapper;
import com.jin321.wx.dao.RollingpickDetailMapper;
import com.jin321.wx.dao.TimeproducDetailMapper;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.model.RollingpickDetail;
import com.jin321.wx.model.TimeproducDetail;
import com.jin321.wx.service.FirstPageService;
import com.jin321.wx.utils.WXUtil;
import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/9/26 17:09
 * @Description :
 */
@Service("firstPageService")
@Transactional(rollbackFor = Exception.class)
public class FirstPageServiceImp implements FirstPageService {
    private static final Log log = LogFactory.getLog(FirstPageServiceImp.class);
    @Autowired
    UserMapper userMapper;      //用户
    @Autowired
    FirstrelateMapper firstrelateMapper;        //一级关系
    @Autowired
    RollingpickDetailMapper rollingpickDetailMapper;        //轮播图活动信息
    @Autowired
    TimeproducDetailMapper timeproducDetailMapper;        //秒杀商品活动信息
    @Autowired
    ProductPoMapper productPoMapper;        //合伙人商品

    String appid = WXUtil.APPID;

    String secret = WXUtil.SECRET;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> getFirstPageMessage() throws Exception {
        Map<String, Object> map = new HashMap<String,Object>();
        //轮播图
        List<RollingpickDetail> rollingpickDetails = rollingpickDetailMapper.selectNow();
        map.put("rollingpicks", rollingpickDetails);
        //秒杀
        List<TimeproducDetail> timeproducDetails = timeproducDetailMapper.selectNowAll();
        map.put("timeproducs", timeproducDetails);
        //合伙人商品
        List<ProductPo> productPos = productPoMapper.selectAllNowTogether();
        map.put("productPos", productPos);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> login(String js_code , String lUserid) throws Exception{
        log.info("appid->" + appid + "secert->" + secret);
        HashMap<String, String> map = new HashMap<String, String>();
        //请求微信服务器
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("appid", appid)
                .add("secret", secret)
                .add("js_code", js_code)
                .add("grant_type", "authorization_code")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        log.info("微信服务器返回："+string);
        Map<String, String> params = JSONObject.parseObject(string, new TypeReference<Map<String, String>>(){});
        String errcode = params.get("errcode");
        if (!StringUtil.isNullString(errcode)) {
            //微信服务器返回错误 {"errcode": 40029,"errmsg": "invalid code"}
            map.put("code", "0");
            map.put("errormessage", string);
            return map;
        }
        //请求成功
        String openid = params.get("openid");
        String session_key = params.get("session_key");
        String unionid = params.get("unionid");
        map.put("openid", openid);
        map.put("session_key", session_key);

        //查询用户是否存在
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserwxidEqualTo(openid);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() == 0) {
            //用户是新用户
            log.info("新用户"+openid);
            User user = new User();
            user.setUid(StringUtil.makeUserid());
            user.setUserwxid(openid);
            userMapper.insert(user);

            if (!StringUtil.isNullString(lUserid)) {
                //校验推荐用户合法性
                User user1 = userMapper.selectByPrimaryKey(lUserid);
                if (user1 == null) {
                    log.info("推介用户非法");
                    map.put("code", "0");
                    map.put("errormessage", "推介用户非法");
                    return map;
                } else {
                    //推介用户合法
                    Firstrelate firstrelate = new Firstrelate();
                    firstrelate.setR1u1id(user.getUid());
                    firstrelate.setR1u2id(user1.getUid());
                    firstrelateMapper.insert(firstrelate);

                    map.put("code", "1");
                    map.put("message", "新用户");
                    map.put("userid", user.getUid());
                }
            } else {
                //无推介用户
                map.put("code", "1");
                map.put("message", "新用户，无推介用户");
                map.put("userid", user.getUid());
            }
        } else {
            //用户是老用户
            log.info("老用户");
            map.put("code", "2");
            map.put("message", "老用户");
            map.put("userid", users.get(0).getUid());
        }
        return map;
    }
}
