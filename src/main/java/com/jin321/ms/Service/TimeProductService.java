package com.jin321.ms.Service;

import com.jin321.pl.model.Timeproduct;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/14.
 *
 * @Description :秒杀商品相关
 */
public interface TimeProductService {
    /**
     * 添加秒杀活动
     * @param timeproduct
     * @return
     */
    int createTimeProduct(Timeproduct timeproduct);

    /**
     * 删除秒杀活动
     * @param tpids
     * @return
     */
    int deleteTimeProduct(List<Integer> tpids);
}
