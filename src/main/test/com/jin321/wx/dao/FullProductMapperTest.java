package com.jin321.wx.dao;

import com.jin321.wx.model.FullProduct;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hao
 * @Date 2017/10/2 17:21
 * @Description :查询商品详细信息测试
 */
public class FullProductMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    FullProductMapper fullProductMapper;

    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        fullProductMapper = (FullProductMapper) classPathXmlApplicationContext.getBean("fullProductMapper");
    }
    @Test
    public void selectFullProductById() throws Exception {
        FullProduct fullProduct = fullProductMapper.selectFullProductById(1);
        System.out.println(fullProduct);
    }

}