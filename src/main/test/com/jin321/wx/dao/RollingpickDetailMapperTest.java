package com.jin321.wx.dao;

import com.jin321.wx.model.RollingpickDetail;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hao
 * @Date 2017/9/28 18:07
 * @Description :
 */
public class RollingpickDetailMapperTest {
    @Test
    public void selectNowByPid() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RollingpickDetailMapper rollingpickDetailMapper = (RollingpickDetailMapper) classPathXmlApplicationContext.getBean("rollingpickDetailMapper");
        RollingpickDetail rollingpickDetail = rollingpickDetailMapper.selectNowByPid(1);
        System.out.println(rollingpickDetail);
    }

}