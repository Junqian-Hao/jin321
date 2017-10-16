package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.OrderFormProductService;
import com.jin321.ms.dao.GetOrderFormDidMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.model.OrderformproductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description :
 */
@Service
public class OrderFormProductServiceimp implements OrderFormProductService {
    @Autowired
    private GetOrderFormDidMapper getOrderFormDidMapper;
    @Override
    public int getOrderDid(Long oid) {
      return getOrderFormDidMapper.getDid(oid);
    }
}
