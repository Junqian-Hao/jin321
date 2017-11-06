package com.jin321.ms.Service;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description :
 */
public interface PayBackEventService {
    /**
     * 添加退货时间
     * @param oid 订单id
     * @param did 经销商id
     * @param msg 退货消息
     * @return
     */
    int insertpaybackevent(Long oid,int did,String msg);
}
