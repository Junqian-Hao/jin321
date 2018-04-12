package com.jin321.ms.Service;

import com.jin321.ms.model.DealerSellProductDetail;
import com.jin321.ms.model.Page;
import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.Orderformproduct;
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

    Page<Dealer> selectAllDealer(int pagenum,int thispage);

    int insertDealer(Dealer dealer);

    public List<Dealer> selectAllDealerName();

    public Page<DealerSellProductDetail> getAllDealerOrderDetail(int pagenum,int thispage,int did,int days);
}
