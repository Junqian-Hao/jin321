package com.jin321.wx.service;

import java.math.BigDecimal;

/**
 * Created by Tyranitarx on 2018/1/24.
 *
 * @Description :
 */
public interface PayBackEventService {
    public int generateEvent(Long oid, int did, BigDecimal backmoney, String message, int pid);
}
