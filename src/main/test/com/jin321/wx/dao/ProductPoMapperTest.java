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
        List<ProductPo> productPos = productPoMapper.selectAllTogether();
        System.out.println(productPos);

    }

}