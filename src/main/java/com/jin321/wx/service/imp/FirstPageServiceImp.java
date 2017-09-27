package com.jin321.wx.service.imp;

import com.jin321.pl.dao.FirstrelateMapper;
import com.jin321.pl.dao.UserMapper;
import com.jin321.pl.model.Firstrelate;
import com.jin321.pl.model.FirstrelateExample;
import com.jin321.pl.model.User;
import com.jin321.pl.model.UserExample;
import com.jin321.pl.utils.StringUtil;
import com.jin321.wx.dao.ProductDetailMapper;
import com.jin321.wx.dao.RollingpickDetailMapper;
import com.jin321.wx.dao.TimeproducDetailMapper;
import com.jin321.wx.model.RollingpickDetail;
import com.jin321.wx.model.TimeproducDetail;
import com.jin321.wx.service.FirstPageService;
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
    ProductDetailMapper productDetailMapper;        //合伙人商品



    public Map<String, Object> getFirstPageMessage(String userId, String lUserId) throws Exception {
        Map<String, Object> map = new HashMap<String,Object>();
//        判断用户是否是第一次进入商城
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserwxidEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.get(0) == null) {
            map.put("code", 1);
            log.debug(userId+"用户是新用户"+"推介者"+lUserId);
//         用户是新用户
//            记录进入用户表
            User user = new User();
            user.setUserwxid(userId);
            userMapper.insert(user);

            if (StringUtil.isNullString(lUserId)) {
//                用户拥有推荐者
//                判断推介者合法性
                UserExample userexample = new UserExample();
                UserExample.Criteria criteria2 = userexample.createCriteria();
                criteria2.andUserwxidEqualTo(userId);
                List<User> lUsers = userMapper.selectByExample(userexample);
                if (lUsers == null || lUsers.get(0) == null) {
//                 推介者合法
                    FirstrelateExample firstrelateExample = new FirstrelateExample();
                    FirstrelateExample.Criteria criteria1 = firstrelateExample.createCriteria();
                    criteria1.andR1u1idEqualTo(users.get(0).getUid());
                    criteria1.andR1u2idEqualTo(lUsers.get(0).getUid());
                    List<Firstrelate> firstrelates = firstrelateMapper.selectByExample(firstrelateExample);
                    if (firstrelates != null && firstrelates.get(0) != null) {
//                        推介记录不存在,记录
                        log.info("推介记录不存在,记录");
                        Firstrelate firstrelate = new Firstrelate();
                        firstrelate.setR1u1id(users.get(0).getUid());
                        firstrelate.setR1u2id(lUsers.get(0).getUid());
                        firstrelateMapper.insert(firstrelate);
                    } else {
                        map.put("code", 0);
                        map.put("errormessage", "推介用户非法，推介用户名："+lUserId);
                        log.info("推介记录存在");
                    }
                } else {
//                    推介用户名为非商城用户
                    log.error("推介用户id为非法id");
                }
            }
        } else {
            map.put("code", 2);
            log.info("老用户登录");
        }
//        查询轮播图商品
        List<RollingpickDetail> rollingpickDetails = rollingpickDetailMapper.selectAll();
        map.put("rollingpick", rollingpickDetails);
//        查询秒杀活动商品
        List<TimeproducDetail> timeproducDetails = timeproducDetailMapper.selectAll();
        map.put("timeproduc", timeproducDetails);
//        查询合伙人商品
        Map<String, Object> map1 = productDetailMapper.selectSimpleTogether();
        map.put("productTogether", map1);
        return map;
    }
}
