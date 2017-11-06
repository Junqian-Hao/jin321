package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.DealerLoginService;


import com.jin321.pl.dao.DealerMapper;
import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.DealerExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/9/30.
 * @Description : 用户登录服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DealerLoginServiceimp implements DealerLoginService {
    private static final Log log = LogFactory.getLog(DealerLoginServiceimp.class);
    @Autowired
    private DealerMapper dealerMapper;
    private List<Dealer> dealers;
    private String power;
    /**
     *
     * @param dusername 经销商用户名
     * @param dpassword 经销商密码
     * @return 若用户不存在返回 0 用户密码错误返回2 商户登录返回4 审核员登录返回5 管理员登录返回6
     */
    @Override
    public int Login(String dusername, String dpassword) {
        DealerExample dealerExample=new DealerExample();
        DealerExample.Criteria criteria=dealerExample.createCriteria();
        criteria.andDusernameEqualTo(dusername);
        dealers=dealerMapper.selectByExample(dealerExample);
        if(dealers.size()>0){
            log.debug("正确密码:"+dealers.get(0).getDpassword());
            log.debug("用户输入密码"+dpassword);
            if (dealers.get(0).getDpassword().equals(dpassword)){
                power=dealerMapper.selectByPrimaryKey(dealers.get(0).getDid()).getDpower();
                    if(power.equals("dealer"))
                        return 4;
                    if(power.equals("assessor"))
                        return 5;
                    else
                        return 6;
                }
                else
                    return 2;
        }
        else
            return 0;

    }

    /**
     *
     * @param dusername
     * @return 非 -1 则返回成功
     */
    @Override
    public int getDealerId(String dusername) {
        DealerExample dealerExample=new DealerExample();
        DealerExample.Criteria criteria=dealerExample.createCriteria();
        criteria.andDusernameEqualTo(dusername);
        dealers=dealerMapper.selectByExample(dealerExample);
        if(dealers.get(0)!=null&&dealers!=null)
            return dealers.get(0).getDid();
        else
            return -1;
    }
}
