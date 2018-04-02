package com.jin321;

import com.jin321.pl.controller.IndexServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: hao
 * @Date: 2018/3/27 20:49
 * @Description: *
 */
@Configuration
public class IndexConfig {
    @Bean
    public ServletRegistrationBean indexServletConfig() {
        return new ServletRegistrationBean(new IndexServlet(), "/");
    }
}
