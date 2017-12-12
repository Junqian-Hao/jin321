package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.TimeProductService;
import com.jin321.pl.dao.TimeproductMapper;
import com.jin321.pl.model.Timeproduct;
import com.jin321.pl.model.TimeproductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/14.
 *
 * @Description :添加秒杀活动
 */
@Service
public class TimeProductServiceimp implements TimeProductService {
    @Autowired
    private TimeproductMapper timeproductMapper;
    private List<Timeproduct> timeproducts;
    private int sign=1;
    private Timeproduct timeproduct;
    @Override
    public int createTimeProduct(List<Integer> hotproductlist) {
        Iterator<Integer> integerIterator=hotproductlist.iterator();
        while (integerIterator.hasNext()) {
            timeproduct=new Timeproduct();
            timeproduct.setPid(integerIterator.next());
            TimeproductExample timeproductExample = new TimeproductExample();
            TimeproductExample.Criteria criteria = timeproductExample.createCriteria();
            criteria.andPidEqualTo(timeproduct.getPid());
            criteria.andIsDeletedEqualTo(false);
            timeproducts = timeproductMapper.selectByExample(timeproductExample);
            if (timeproducts.size() > 0)
                sign=-1;
            else {
                timeproduct.setIsDeleted(false);
                timeproductMapper.insert(timeproduct);
            }
        }
        return sign;
    }

    @Override
    public int deleteTimeProduct(List<Integer> tpids) {
        Iterator<Integer> iterator=tpids.iterator();
        while (iterator.hasNext()){
            timeproduct= timeproductMapper.selectByPrimaryKey(iterator.next());
            timeproduct.setIsDeleted(true);
            sign=timeproductMapper.updateByPrimaryKey(timeproduct);
            if(sign==0)
                return 0;
        }
        return sign;
    }
}
