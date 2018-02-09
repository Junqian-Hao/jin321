package com.jin321.ms.event;

import com.jin321.pl.dao.RollingpickMapper;
import com.jin321.pl.model.Rollingpick;
import com.jin321.pl.model.RollingpickExample;
import com.jin321.wx.task.DBTimerTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/12/6.
 *
 * @Description :
 */
@Component
public class DeleteRollingpicEvent {
    private static final Log log = LogFactory.getLog(DBTimerTask.class);

    @Scheduled(cron = "0 0 1 L * ?")
    public void run(){
        /*RollingpickExample rollingpickExample=new RollingpickExample();
        RollingpickExample.Criteria criteria=rollingpickExample.createCriteria();
        criteria.andIsDeletedEqualTo(true);
        rollingpicks=rollingpickMapper.selectByExample(rollingpickExample);
        Iterator<Rollingpick> iterator=rollingpicks.iterator();
        while (iterator.hasNext()){
            String picname=iterator.next().getRpicurl();
            File file=new File(picname);
            file.delete();
        }*/
    }
}
