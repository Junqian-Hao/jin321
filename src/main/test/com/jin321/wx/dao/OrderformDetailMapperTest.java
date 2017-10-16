package com.jin321.wx.dao;

import com.jin321.wx.model.OrderformProductDetail;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
    public void selectOrderformByuid() throws Exception {
        List<OrderformProductDetail> orderformProductDetails = orderformDetailMapper.selectOrderformByuid(1 + "");
        System.out.println(orderformProductDetails);
    }

}