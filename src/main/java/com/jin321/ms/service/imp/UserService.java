package com.jin321.ms.service.imp;

import com.jin321.ms.dao.UserMapper;
import com.jin321.ms.model.User;
import com.jin321.ms.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/18 23:18
 * @Description :
 */
@Service("userService")
public class UserService implements com.jin321.ms.service.UserService {
    @Autowired
    UserMapper userMapper;
    public User select() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }
}
