package com.jin321.ms.dao;

import com.jin321.pl.model.Product;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

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
