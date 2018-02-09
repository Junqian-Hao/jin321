package com.jin321.ms.Service;

import com.jin321.ms.model.OrderFormDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(rollbackFor = Exception.class)
    public List<OrderFormDetails> getReadyOrderform(int did);

    @Transactional(rollbackFor = Exception.class)
    public List<OrderFormDetails> getUnReadyOrderfrom(int did);

    @Transactional(rollbackFor = Exception.class)
    public List<OrderFormDetails> getconfirmForm(int did);

}
