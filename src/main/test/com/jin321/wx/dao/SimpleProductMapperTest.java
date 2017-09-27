package com.jin321.wx.dao;

import com.jin321.wx.model.SimpleProduct;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hao
 * @Date 2017/9/27 13:22
 * @Description :
 */
public class SimpleProductMapperTest {
    ApplicationContext applicationContext;

    @Test
    public void selectNowSimpleProduct() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SimpleProductMapper simpleProductMapper = (SimpleProductMapper) applicationContext.getBean("simpleProductMapper");
        SimpleProduct simpleProduct = simpleProductMapper.selectNowSimpleProduct(1);
        System.out.println(simpleProduct);
    }

}