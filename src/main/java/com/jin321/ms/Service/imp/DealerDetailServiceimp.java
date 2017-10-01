package com.jin321.ms.Service.imp;

import com.jin321.ms.dao.DealerLoginMapper;
import com.jin321.ms.model.DealerLogin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Tyranitarx on 2017/9/30.
 *
 * @Description :
 */
public class DealerDetailServiceimp implements DealerLoginMapper{
    @Autowired
    private DealerLoginMapper dealerLoginMapper;
    @Override
    public DealerLogin Login(String dusername) {
        return dealerLoginMapper.Login(dusername);
    }
}
