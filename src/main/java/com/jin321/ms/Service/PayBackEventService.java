package com.jin321.ms.Service;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

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
     * @return !废弃！
     */
    int insertpaybackevent(Long oid,int did,String msg);
    /**
     *向微信发起退款
     */
    int payback(Long eid,int status) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, JDOMException;
}
