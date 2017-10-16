package com.jin321.wx.service.imp;

import com.jin321.pl.dao.UseraddressMapper;
import com.jin321.pl.model.Useraddress;
import com.jin321.pl.model.UseraddressExample;
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
        int insert = useraddressMapper.insert(useraddress);
        if (insert > 0) {
            return true;
        }
        log.warn("添加收货地址，数据库插入错误"+useraddress);
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
        log.warn("删除收货地址，数据库错误"+uaid);
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
        log.warn("修改收货地址，数据库错误"+useraddress);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Useraddress> selectUseraddressByuid(String uid) throws Exception {
        UseraddressExample useraddressExample = new UseraddressExample();
        UseraddressExample.Criteria criteria = useraddressExample.createCriteria();
        criteria.andUidEqualTo(uid);
        List<Useraddress> useraddresses = useraddressMapper.selectByExample(useraddressExample);
        return useraddresses;
    }
}
