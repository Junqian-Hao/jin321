package com.jin321.wx.service.imp;

import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.PaybackeventMapper;
import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.OrderformproductExample;
import com.jin321.pl.model.Paybackevent;
import com.jin321.wx.service.PayBackEventService;
import com.jin321.wx.utils.OidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/24.
 *
 * @Description :
 */
@Service
public class PayBackEventServiceImp implements PayBackEventService{
    @Autowired
    private PaybackeventMapper paybackeventMapper;
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private OrderformproductMapper orderformproductMapper;
    private Orderform orderform;
    private List<Orderformproduct> orderformproductList;
    private Orderformproduct orderformproduct;
    private Paybackevent paybackevent;
    @Override
    public int generateEvent(Long oid, int did, BigDecimal backmoney, String message,int pid) {
        paybackevent=new Paybackevent();
        orderform=orderformMapper.selectByPrimaryKey(oid);
        OrderformproductExample orderformproductExample=new OrderformproductExample();
        OrderformproductExample.Criteria criteria=orderformproductExample.createCriteria();
        criteria.andOidEqualTo(oid);
        criteria.andPidEqualTo(pid);
        orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
        orderformproduct=orderformproductList.get(0);
        orderformproduct.setStatus(1);
        orderformproductMapper.updateByPrimaryKey(orderformproduct);
        paybackevent.setEid(OidUtil.newOid());
        paybackevent.setBackprice(backmoney);
        paybackevent.setEventstatus(1);
        paybackevent.setDid(did);
        paybackevent.setIsDeleted(false);
        paybackevent.setMessagedetail(message);
        return paybackeventMapper.insert(paybackevent);
    }
}
