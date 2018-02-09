package com.jin321.ms.Service.imp;


import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.dao.SelectSidInFormMapper;
import com.jin321.ms.model.OrderFormDetails;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
@Service
public class OrderFormServiceimp implements OrderFormService {
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private OrderformproductMapper orderformproductMapper;
    @Autowired
    private SelectSidInFormMapper selectSidInFormMapper;
    private Orderform orderform;
    private OrderFormDetails orderformDetails;
    private List<OrderFormDetails> orderFormDetailsList;
    private List<Orderform> orderformList;
    private List<Orderformproduct> orderformproductList;

    @Override
    public List<OrderFormDetails> getReadyOrderform(int did) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(2);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails =new OrderFormDetails();
            orderformDetails.setOrderform(orderform);
            orderformDetails.setOrderformproductList(orderformproductList);
            orderFormDetailsList.add(orderformDetails);
        }
        return orderFormDetailsList;
    }

    @Override
    public List<OrderFormDetails> getUnReadyOrderfrom(int did) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(1);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails =new OrderFormDetails();
            orderformDetails.setOrderform(orderform);
            orderformDetails.setOrderformproductList(orderformproductList);
            orderFormDetailsList.add(orderformDetails);
        }
        return orderFormDetailsList;
    }

    @Override
    public List<OrderFormDetails> getconfirmForm(int did) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(4);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails =new OrderFormDetails();
            orderformDetails.setOrderform(orderform);
            orderformDetails.setOrderformproductList(orderformproductList);
            orderFormDetailsList.add(orderformDetails);
        }
        return orderFormDetailsList;
    }

    @Override
    public int sendOrderFormStatue(Long oid, String osendmethod, String osendnumber) {
        orderform=orderformMapper.selectByPrimaryKey(oid);
        orderform.setOsendmethod(osendmethod);
        orderform.setOsendnumber(osendnumber);
        orderform.setOsenddate(new Date());
        return orderformMapper.updateByPrimaryKey(orderform);
    }

    private List<Integer> sidlist;
    @Autowired
    private ProductsizeMapper productsizeMapper;
    private Productsize productsize;
    private int sign;
    @Override
    public int decreaseOrderProductNum(Long oid) {
        sidlist= selectSidInFormMapper.selectsid(oid);
        Iterator<Integer> iterator=sidlist.iterator();
        while (iterator.hasNext()){
            productsize=productsizeMapper.selectByPrimaryKey(iterator.next());
            productsize.setSnumber(productsize.getSnumber()-1);
            sign=productsizeMapper.updateByPrimaryKey(productsize);
            if (sign==0)
                return 0;
        }
        return sign;
    }
}
