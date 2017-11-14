package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.RollingPicService;
import com.jin321.pl.dao.RollingpickMapper;
import com.jin321.pl.model.ProductExample;
import com.jin321.pl.model.Rollingpick;
import com.jin321.pl.model.RollingpickExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/7.
 *
 * @Description : 轮播图服务逻辑
 */
@Service
public class RollingPicServiceimp implements RollingPicService {
    @Autowired
    private RollingpickMapper rollingpickMapper;
    private Rollingpick rollingpick;
    private List<Rollingpick> rollingpickList;
    private int sign;
    @Override
    public int insertRollingPic(Rollingpick rollingpick) {
        return rollingpickMapper.insert(rollingpick);
    }
    @Override
    public int deleteAllRollingPic(){
        RollingpickExample rollingpickExample=new RollingpickExample();
        RollingpickExample.Criteria criteria=rollingpickExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        rollingpickList=rollingpickMapper.selectByExample(rollingpickExample);
        Iterator<Rollingpick> iterator=rollingpickList.iterator();
        while(iterator.hasNext()){
            rollingpick= iterator.next();
            sign=rollingpickMapper.deleteByPrimaryKey(rollingpick.getRpid());
            if(sign==0)
                return 0;
        }
        return 1;
    }
    @Override
    public int deleteRollingPic(int rpid) {
        rollingpick=rollingpickMapper.selectByPrimaryKey(rpid);
        if(rollingpick!=null){
            rollingpick.setIsDeleted(true);
            return rollingpickMapper.updateByPrimaryKey(rollingpick);
        }
        return -1;
    }
}
