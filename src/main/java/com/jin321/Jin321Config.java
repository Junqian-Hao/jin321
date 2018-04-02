package com.jin321;


import com.jin321.pl.controller.Jin321Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: hao
 * @Date: 2018/3/27 20:49
 * @Description: *
 */
@Configuration
public class Jin321Config {
    @Bean
    public ServletRegistrationBean jin321ServletConfig() {
        return new ServletRegistrationBean(new Jin321Servlet(), "/jin321");
    }
}
