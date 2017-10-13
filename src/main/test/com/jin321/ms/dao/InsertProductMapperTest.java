package com.jin321.ms.dao;

import com.jin321.pl.model.Product;
import com.jin321.wx.dao.ProductPoMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tyranitarx on 2017/10/8.
 *
 * @Description :
 */
public class InsertProductMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    InsertProductMapper insertProductMapper;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       insertProductMapper = (InsertProductMapper) classPathXmlApplicationContext.getBean("InsertProductMapper");
    }
    @Test
    public void get(){
        Product product=new Product();
        insertProductMapper.insertProduct(product);
        System.out.println(product.getPid());
    }
}