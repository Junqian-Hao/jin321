package com.jin321.wx.dao;

import com.jin321.pl.model.Orderform;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hao
 * @Date 2017/10/11 15:08
 * @Description :
 */
public class OrderformDetailMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    OrderformDetailMapper orderformDetailMapper;

    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        orderformDetailMapper = (OrderformDetailMapper) classPathXmlApplicationContext.getBean("orderformDetailMapper");
    }
    @Test
    public void insert() throws Exception {
        Orderform orderform = new Orderform();
        orderform.setOmessage("klalalla");
        int insert = orderformDetailMapper.insert(orderform);
        System.out.println(insert);
        System.out.println(orderform.getOid());
    }

}