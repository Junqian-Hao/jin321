package com.jin321.wx.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

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
//        FullProduct fullProduct = fullProductMapper.selectFullProductById(1);
//        System.out.println(fullProduct);
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long("1507954860000");
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        System.out.println(res);
    }

}