package com.jin321.ms.Service;

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
    int Login(String dusername,String dpassword);
    /**
     * 获取经销商id
     * @param dusername
     * @return
     */
    int getDealerId(String dusername);
}
