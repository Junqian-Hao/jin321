package com.jin321.wx.service.imp;

import com.jin321.pl.dao.UseraddressMapper;
import com.jin321.pl.model.Useraddress;
import com.jin321.pl.model.UseraddressExample;
import com.jin321.pl.utils.StringUtil;
import com.jin321.wx.service.UseraddressService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/10 18:38
 * @Description :用户收货地址业务逻辑
 */
@Service("useraddressService")
public class UseraddressServiceImp implements UseraddressService {
    private static final Log log = LogFactory.getLog(UseraddressServiceImp.class);
    @Autowired
    UseraddressMapper useraddressMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUseraddress(Useraddress useraddress) throws Exception {
        useraddress.setAddtime(new Date());

        String uaddress = useraddress.getUaddress();
        if (StringUtil.isNullString(uaddress)) {
            useraddress.setUcountry("中国");
        }

        Boolean adddefault = useraddress.getAdddefault();
        if (adddefault == null) {
            useraddress.setAdddefault(false);
        }

        useraddress.setIsDeleted(false);

        int insert = useraddressMapper.insert(useraddress);
        if (insert > 0) {
            return true;
        }
        log.warn("添加收货地址，数据库插入错误" + useraddress);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUseraddressByid(int uaid) throws Exception {
        Useraddress useraddress = useraddressMapper.selectByPrimaryKey(uaid);
        useraddress.setIsDeleted(true);
        int i = useraddressMapper.updateByPrimaryKeySelective(useraddress);
        if (i > 0) {
            return true;
        }
        log.warn("删除收货地址，数据库错误" + uaid);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUseraddressByid(Useraddress useraddress) throws Exception {
        useraddress.setAddtime(new Date());
        int i = useraddressMapper.updateByPrimaryKeySelective(useraddress);
        if (i > 0) {
            return true;
        }
        log.warn("修改收货地址，数据库错误" + useraddress);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Useraddress> selectUseraddressByuid(String uid) throws Exception {
        UseraddressExample useraddressExample = new UseraddressExample();
        UseraddressExample.Criteria criteria = useraddressExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andIsDeletedEqualTo(false);
        useraddressExample.setOrderByClause("adddefault desc");
        List<Useraddress> useraddresses = useraddressMapper.selectByExample(useraddressExample);
        return useraddresses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean setDefaultAddress(int uaid) throws Exception {
        //查询目标收货地址
        Useraddress useraddress = useraddressMapper.selectByPrimaryKey(uaid);
        if (useraddress == null) {
            log.error("设置默认收货地址错误，uaid-》" + uaid + "不存在");
            return false;
        }
        //将目标收货地址的原默认地址置为false
        UseraddressExample useraddressExample = new UseraddressExample();
        UseraddressExample.Criteria criteria = useraddressExample.createCriteria();
        criteria.andUidEqualTo(useraddress.getUid());
        criteria.andAdddefaultEqualTo(true);
        criteria.andIsDeletedEqualTo(false);
        List<Useraddress> useraddresses = useraddressMapper.selectByExample(useraddressExample);
        log.debug("原默认收货地址"+useraddress);
        if (useraddresses != null && useraddresses.size() > 0) {
            for (Useraddress address : useraddresses) {
                address.setAdddefault(false);
                useraddressMapper.updateByPrimaryKey(address);
            }
        }
        //将目标地址置为默认
        useraddress.setAdddefault(true);
        useraddressMapper.updateByPrimaryKey(useraddress);
        return true;
    }
}
