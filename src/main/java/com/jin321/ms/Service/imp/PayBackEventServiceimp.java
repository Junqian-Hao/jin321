package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.PayBackEventService;
import com.jin321.pl.dao.PaybackeventMapper;
import com.jin321.pl.model.Paybackevent;
import com.jin321.pl.utils.PayBackEventState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description : 用户申请退单服务
 */
@Service
public class PayBackEventServiceimp implements PayBackEventService{
    @Autowired
    private PaybackeventMapper paybackeventMapper;
    private Paybackevent paybackevent;
    @Override
    public int insertpaybackevent(Long oid, int did, String msg) {
        paybackevent=new Paybackevent();
        paybackevent.setIsDeleted(false);
        paybackevent.setOid(oid);
        paybackevent.setDid(did);
        paybackevent.setEventstatus(PayBackEventState.REQUEST_PAYBACK);
        paybackevent.setMessagedetail(msg);
        return paybackeventMapper.insert(paybackevent);
    }
}
