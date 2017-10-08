package com.jin321.ms.dao;


import com.jin321.ms.model.DealerLogin;
import org.springframework.stereotype.Repository;

/**
 * Created by Tyranitarx on 2017/10/1.
 *
 * @Description :
 */
@Repository("DealerExistMapper")
public interface DealerExistMapper {
    /**
     * 检查用户是否存在
     * @param dusername 用户名
     * @return
     */
    DealerLogin checkDealer(String dusername);
}
