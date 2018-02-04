package com.jin321.ms.Service;

import com.jin321.pl.model.Orderform;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
public interface OrderFormService {
    /**
     * 修改订单状态
     * @param
     * @param oid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int sendOrderFormStatue(Long oid,String osendmethod,String osendnumber);

    /**
     *
     * @param oid 订单ID
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int decreaseOrderProductNum(Long oid);
}
