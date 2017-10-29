package com.jin321.ms.dao;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tyranitarx on 2017/10/15.
 *
 * @Description :
 */

public class GetOrderFormDidMapperTest{
        private ClassPathXmlApplicationContext classPathXmlApplicationContext;
        GetOrderFormDidMapper getOrderFormDidMapper;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        getOrderFormDidMapper = (GetOrderFormDidMapper) classPathXmlApplicationContext.getBean("GetOrderFormDidMapper");
    }
    @Test
    public void get(){

    }

}
