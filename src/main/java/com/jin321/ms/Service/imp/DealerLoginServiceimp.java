package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.DealerLoginService;



import com.jin321.pl.dao.DealerMapper;

import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.DealerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/9/30.
 * @Description : 用户登录服务
 */
@Service("dealerLoginService")
@Transactional(rollbackFor = Exception.class)
public class DealerLoginServiceimp implements DealerLoginService {
    @Autowired
    private DealerMapper dealerMapper;
    private List<Dealer> dealers;
    /**
     *
     * @param dusername 经销商用户名
     * @param dpassword 经销商密码
     * @return 若用户不存在返回 0 用户密码错误返回2 用户登录成功返回1
     */
    @Override
    public int Login(String dusername, String dpassword) {
        DealerExample dealerExample=new DealerExample();
        DealerExample.Criteria criteria=dealerExample.createCriteria();
        criteria.andDusernameEqualTo(dusername);
        dealers=dealerMapper.selectByExample(dealerExample);
        if(dealers!=null){
                if (dealers.get(0).getDpassword()==dpassword)
                    return 1;
                else
                    return 2;
        }
        else
            return 0;

    }
}
