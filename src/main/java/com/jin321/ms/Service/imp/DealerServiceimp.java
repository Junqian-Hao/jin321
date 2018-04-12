package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.DealerService;
import com.jin321.ms.dao.GetDealerSellProductDetaiMapper;
import com.jin321.ms.model.DealerSellProductDetail;
import com.jin321.ms.model.Page;
import com.jin321.pl.dao.DealerMapper;
import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.DealerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description :查询所有商户服务
 */
@Service
public class DealerServiceimp implements DealerService {
    @Autowired
    private DealerMapper dealerMapper;
    @Autowired
    private GetDealerSellProductDetaiMapper getDealerSellProductDetaiMapper;
    private List<Dealer> dealerList;
    @Override
    public Page<Dealer> selectAllDealer(int pagenum, int thispage) {
        DealerExample example=new DealerExample();
        DealerExample.Criteria criteria=example.createCriteria();
        criteria.andDpowerEqualTo("dealer");
        dealerList=dealerMapper.selectByExample(example);
        return new Page<Dealer>().getPageList(pagenum,thispage,dealerList);
    }
    @Override
    public List<Dealer> selectAllDealerName() {
        DealerExample example=new DealerExample();
        DealerExample.Criteria criteria=example.createCriteria();
        criteria.andDpowerEqualTo("dealer");
        dealerList=dealerMapper.selectByExample(example);
        return dealerList;
    }
    private List<Dealer> oldDealer;
    @Override
    public int insertDealer(Dealer dealer) {
        DealerExample example=new DealerExample();
        DealerExample.Criteria criteria=example.createCriteria();
        criteria.andDnameEqualTo(dealer.getDname());
        dealer.setIsDeleted(false);
        oldDealer=dealerMapper.selectByExample(example);
        if (oldDealer.size()>0)
            return -1;
        else return dealerMapper.insert(dealer);
    }

    @Override
    public Page<DealerSellProductDetail> getAllDealerOrderDetail(int pagenum, int thispage, int did,int days) {
        return new Page<DealerSellProductDetail>().getPageList(pagenum,thispage,getDealerSellProductDetaiMapper.getDealerSellProductDetail(did,days));
    }
}
