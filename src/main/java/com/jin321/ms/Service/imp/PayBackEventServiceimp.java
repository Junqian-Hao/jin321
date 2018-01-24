package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.PayBackEventService;
import com.jin321.ms.util.WXPayBackUtil;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.PaybackeventMapper;
import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.OrderformproductExample;
import com.jin321.pl.model.Paybackevent;
import com.jin321.pl.utils.PayBackEventState;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        paybackevent.setEventstatus(PayBackEventState.REQUEST_PARTPAYBACK);
        paybackevent.setMessagedetail(msg);
        return paybackeventMapper.insert(paybackevent);
    }
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private OrderformproductMapper orderformproductMapper;
    private List<Orderformproduct> orderformproductList;
    private Orderform orderform;
    private BigDecimal total=new BigDecimal(0);
    private Map returnMap;
    @Override
    public int payback(Long eid, int status) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, JDOMException {
            paybackevent=paybackeventMapper.selectByPrimaryKey(eid);
            orderform=orderformMapper.selectByPrimaryKey(paybackevent.getOid());
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteria=orderformproductExample.createCriteria();
            criteria.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            Iterator<Orderformproduct> iterator=orderformproductList.iterator();
            while (iterator.hasNext()){
                total.add(iterator.next().getPbuyprice());
            }
            returnMap=WXPayBackUtil.WXPayBack(paybackevent.getOid(),paybackevent.getEid(),total,paybackevent.getBackprice());
            if (returnMap.get("return_code").equals("SUCCESS"))
                return 1;
            else
                return 0;

    }
}
