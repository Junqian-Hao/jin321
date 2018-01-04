package com.jin321.ms.Service.imp;


import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.dao.SelectSidInFormMapper;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.Productsize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private SelectSidInFormMapper selectSidInFormMapper;
    private Orderform orderform;
    @Override
    public int changeOrderFormStatue(int ostate,Long oid,Date odate){
        orderform=orderformMapper.selectByPrimaryKey(oid);
        if(orderform!=null){
            orderform.setOstate(ostate);
            orderform.setOpaydate(odate);
            return orderformMapper.updateByPrimaryKey(orderform);
        }else
            return -1;
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
