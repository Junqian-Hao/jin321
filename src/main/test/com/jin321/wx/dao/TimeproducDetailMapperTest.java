package com.jin321.wx.dao;

import com.jin321.wx.model.TimeproducDetail;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/29 15:22
 * @Description :
 */
public class TimeproducDetailMapperTest {

    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    TimeproducDetailMapper timeproducDetailMapper;

    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        timeproducDetailMapper = (TimeproducDetailMapper) classPathXmlApplicationContext.getBean("timeproducDetailMapper");
    }

    @Test
    public void selectAll() throws Exception {
        List<TimeproducDetail> timeproducDetails = timeproducDetailMapper.selectNowAll();
        System.out.println(timeproducDetails);
    }

}