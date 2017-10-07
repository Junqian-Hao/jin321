package com.jin321.ms.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description :
 */
public class ProductInsertMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    ProductInsertMapper productInsertMapper;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
         productInsertMapper= (ProductInsertMapper) classPathXmlApplicationContext.getBean("ProductInsertMapper");
    }
    @Test
    public void insertProduct() throws Exception {
        System.out.println(productInsertMapper.insertProduct(1,"郝俊谦","郝俊谦真牛逼啊",1,1,1,0));
    }
}