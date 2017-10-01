package com.jin321.ms.dao;



import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created by Tyranitarx on 2017/9/30.
 *
 * @Description :
 */
public class DealerLoginMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
   DealerLoginMapper dealerLoginMapper;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        dealerLoginMapper = (DealerLoginMapper) classPathXmlApplicationContext.getBean("DealerLoginMapper");
    }
   @Test
    public void login() throws Exception {
        System.out.println(dealerLoginMapper.Login("123"));
    }

}