package com.jin321.ms.Service;

import com.jin321.pl.model.Dealer;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2017/9/30.
 * @Description:管理系统经销商登录逻辑
 */
public interface DealerLoginService {
    /**
     * 经销商后台登录
     * @param dusername 经销商用户名
     * @param dpassword 经销商密码
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int Login(String dusername,String dpassword);
    @Transactional(rollbackFor = Exception.class)
    int getDealerId(String dusername);
}
