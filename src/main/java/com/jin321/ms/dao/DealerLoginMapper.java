package com.jin321.ms.dao;

import com.jin321.ms.model.DealerLogin;
import org.springframework.stereotype.Repository;



/**
 * Created by Tyranitarx on 2017/9/30.
 *
 * @Description :
 */
@Repository("DealerLoginMapper")
public interface DealerLoginMapper{
    /**
     * 登录MAP
     * @param Username
     * @return
     */
    DealerLogin Login(String Username);
}
