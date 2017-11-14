package com.jin321.ms.Service;

import com.jin321.pl.model.Dealer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :
 */
public interface DealerService {
    /**
     * 查询所有商家
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    List<Dealer> selectAllDealer();
    @Transactional(rollbackFor = Exception.class)
    int insertDealer(Dealer dealer);
}
