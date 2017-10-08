package com.jin321.wx.dao;

import com.jin321.wx.model.ProductPo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/29 15:40
 * @Description :
 */
public class ProductPoMapperTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    ProductPoMapper productPoMapper;

    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        productPoMapper = (ProductPoMapper) classPathXmlApplicationContext.getBean("productPoMapper");
    }
    @Test
    public void selectAllTogether() throws Exception {
        List<ProductPo> productPos = productPoMapper.selectAllNowTogether();
        System.out.println(productPos);
//        long l = System.currentTimeMillis();
//        System.out.println("第一次获得的毫秒值" + l);
//        System.out.println("等待");
//        long l2 = System.currentTimeMillis();
//        System.out.println("第二次获得的毫秒值" + l2);
//        long l3 = (System.currentTimeMillis()-2592000000l);
//        System.out.println("回退一个月的毫秒值" + l3);
//        System.out.println(l-l3);
    }

}