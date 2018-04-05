package com.jin321.ms.Service.imp;


import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.dao.GetProductSizeDetailBySidMapper;
import com.jin321.ms.dao.SelectSidInFormMapper;
import com.jin321.ms.model.OrderFormDetails;
import com.jin321.ms.model.OrderFormProductDetails;
import com.jin321.ms.model.Page;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.dao.UseraddressMapper;
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
    private UseraddressMapper useraddressMapper;
    @Autowired
    private SelectSidInFormMapper selectSidInFormMapper;
    @Autowired
    private GetProductSizeDetailBySidMapper getProductSizeDetailBySidMapper;
    private Orderform orderform;
    private OrderFormDetails orderformDetails;
    private List<OrderFormDetails> orderFormDetailsList;
    private List<Orderform> orderformList;
    private List<Orderformproduct> orderformproductList;
    private OrderFormProductDetails orderFormProductDetails;
    private List<OrderFormProductDetails> orderFormProductDetailsList;

    @Override
    public Page<OrderFormDetails> getReadyOrderform(int did,int pagenum,int thispage) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(2);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails=new OrderFormDetails();
            Iterator<Orderformproduct> orderformproductIterator=orderformproductList.iterator();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            while (orderformproductIterator.hasNext()){
                Orderformproduct orderformproduct= orderformproductIterator.next();
                orderFormProductDetails =new OrderFormProductDetails();
                orderFormProductDetails.setOrderformproduct(orderformproduct);
                orderFormProductDetails.setUpdateProductSizeDetail(getProductSizeDetailBySidMapper.getDetial(orderformproduct.getSid()));
                orderFormProductDetailsList.add(orderFormProductDetails);
            }
            orderformDetails.setOrderform(orderform);
            orderformDetails.setUseraddress(useraddressMapper.selectByPrimaryKey(orderform.getUaid()));
            orderformDetails.setOrderFormProductDetails(orderFormProductDetailsList);
            orderFormDetailsList.add(orderformDetails);
        }
        return new Page<OrderFormDetails>().getPageList(pagenum,thispage,orderFormDetailsList);
    }

    @Override
    public Page<OrderFormDetails> getUnReadyOrderfrom(int did,int pagenum,int thispage) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(1);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails=new OrderFormDetails();
            Iterator<Orderformproduct> orderformproductIterator=orderformproductList.iterator();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            while (orderformproductIterator.hasNext()){
                Orderformproduct orderformproduct= orderformproductIterator.next();
                orderFormProductDetails =new OrderFormProductDetails();
                orderFormProductDetails.setOrderformproduct(orderformproduct);
                orderFormProductDetails.setUpdateProductSizeDetail(getProductSizeDetailBySidMapper.getDetial(orderformproduct.getSid()));
                orderFormProductDetailsList.add(orderFormProductDetails);
            }
            orderformDetails.setOrderform(orderform);
            orderformDetails.setUseraddress(useraddressMapper.selectByPrimaryKey(orderform.getUaid()));
            orderformDetails.setOrderFormProductDetails(orderFormProductDetailsList);
            orderFormDetailsList.add(orderformDetails);
        }
        return new Page<OrderFormDetails>().getPageList(pagenum,thispage,orderFormDetailsList);
    }

    @Override
    public Page<OrderFormDetails> getconfirmForm(int did,int pagenum,int thispage) {
        orderFormDetailsList =new ArrayList<OrderFormDetails>();
        OrderformExample orderformExample=new OrderformExample();
        OrderformExample.Criteria criteria=orderformExample.createCriteria();
        criteria.andDidEqualTo(did);
        criteria.andOstateEqualTo(4);
        orderformList=orderformMapper.selectByExample(orderformExample);
        Iterator<Orderform> orderformIterator=orderformList.iterator();
        while(orderformIterator.hasNext()){
            orderform=orderformIterator.next();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteriaop=orderformproductExample.createCriteria();
            criteriaop.andOidEqualTo(orderform.getOid());
            orderformproductList=orderformproductMapper.selectByExample(orderformproductExample);
            orderformDetails=new OrderFormDetails();
            Iterator<Orderformproduct> orderformproductIterator=orderformproductList.iterator();
            orderFormProductDetailsList =new ArrayList<OrderFormProductDetails>();
            while (orderformproductIterator.hasNext()){
                Orderformproduct orderformproduct= orderformproductIterator.next();
                orderFormProductDetails =new OrderFormProductDetails();
                orderFormProductDetails.setOrderformproduct(orderformproduct);
                orderFormProductDetails.setUpdateProductSizeDetail(getProductSizeDetailBySidMapper.getDetial(orderformproduct.getSid()));
                orderFormProductDetailsList.add(orderFormProductDetails);
            }
            orderformDetails.setOrderform(orderform);
            orderformDetails.setUseraddress(useraddressMapper.selectByPrimaryKey(orderform.getUaid()));
            orderformDetails.setOrderFormProductDetails(orderFormProductDetailsList);
            orderFormDetailsList.add(orderformDetails);
        }
        return new Page<OrderFormDetails>().getPageList(pagenum,thispage,orderFormDetailsList);
    }

    @Override
    public int sendOrderFormStatue(Long oid, String osendmethod, String osendnumber) {
        orderform=orderformMapper.selectByPrimaryKey(oid);
        orderform.setOsendmethod(osendmethod);
        orderform.setOsendnumber(osendnumber);
        orderform.setOstate(2);
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
