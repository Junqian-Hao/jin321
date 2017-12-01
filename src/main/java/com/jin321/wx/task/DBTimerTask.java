package com.jin321.wx.task;

import com.jin321.pl.dao.RollingpickMapper;
import com.jin321.pl.model.Rollingpick;
import com.jin321.pl.model.RollingpickExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/11/30 11:43
 * @Description :解决数据库连接断开的定时任务
 */
@Component
public class DBTimerTask {
    private static final Log log = LogFactory.getLog(DBTimerTask.class);
    @Autowired
    RollingpickMapper rollingpickMapper;

    @Scheduled(cron = "0 0 0/7 * * ?")
    public void run() {
        log.info("定时心跳数据库保持连接");
        List<Rollingpick> rollingpicks = rollingpickMapper.selectByExample(new RollingpickExample());
        log.info("心跳返回："+rollingpicks);
    }
}
