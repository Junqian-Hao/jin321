package com.jin321.ms.dao;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * Created by Tyranitarx on 2017/10/6.
 *
 * @Description :
 */
public class AddProductSizeMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    AddProductSizeMapper addProductSizeMapper;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        addProductSizeMapper = (AddProductSizeMapper) classPathXmlApplicationContext.getBean("AddProductSizeMapper");
    }
    @Test
    public void addProductSize() throws Exception {
        BigDecimal price=BigDecimal.valueOf(1.22);
        System.out.println(addProductSizeMapper.addProductSize(1,price,price,price,"郝俊谦牛逼",999));
    }
}