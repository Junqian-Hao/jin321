package com.jin321.ms.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/14.
 *
 * @Description :秒杀商品相关
 */
public interface TimeProductService {
    /**
     * 添加秒杀活动
     * @param hotproducts
     * @return
     */
    int createTimeProduct(List<Integer> hotproducts);

    /**
     * 删除秒杀活动
     * @param tpids
     * @return
     */
    int deleteTimeProduct(List<Integer> tpids);
}
