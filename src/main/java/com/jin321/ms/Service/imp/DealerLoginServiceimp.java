package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.DealerLoginService;
import com.jin321.ms.dao.DealerExistMapper;
import com.jin321.ms.dao.DealerLoginMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2017/9/30.
 * @Description : 用户登录服务
 */
@Service("dealerLoginService")
@Transactional(rollbackFor = Exception.class)
public class DealerLoginServiceimp implements DealerLoginService {
    @Autowired
    private DealerLoginMapper dealerLoginMapper;
    @Autowired
    private DealerExistMapper dealerExistMapper;

    /**
     *
     * @param dusername 经销商用户名
     * @param dpassword 经销商密码
     * @return 若用户不存在返回 0 用户密码错误返回2 用户登录成功返回1
     */
    @Override
    public int Login(String dusername, String dpassword) {
      if(dealerExistMapper.checkDealer(dusername)!=null){
          if(dealerLoginMapper.dealerLogin(dusername).getDpassword().equals(dpassword)){
              return 1;
          }
          else {
              return 0;
          }
      }
      else
            return 2;
      }
}
