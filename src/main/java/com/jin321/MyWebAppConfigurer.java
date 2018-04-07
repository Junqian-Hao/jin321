package com.jin321;

import com.jin321.ms.interceptors.LoginInterceptor;
import com.jin321.pl.intercepts.SuffixIntercetp;
import com.jin321.pl.utils.UrlUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    private static final Log log = LogFactory.getLog(MyWebAppConfigurer.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SuffixIntercetp()).addPathPatterns("/wx/**");
        registry.addInterceptor(new SuffixIntercetp()).addPathPatterns("/ms/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/ms/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            log.info("当前操作系统为windows");
            createDir(UrlUtil.win_productdetail);
            createDir(UrlUtil.win_productpics);
            createDir(UrlUtil.win_productsecondtype);
            createDir(UrlUtil.win_rollingpick);
            registry.addResourceHandler("/productdetail/**").addResourceLocations("file:" + UrlUtil.win_productdetail);
            registry.addResourceHandler("/productpics/**").addResourceLocations("file:" + UrlUtil.win_productpics);
            registry.addResourceHandler("/productsecondtype/**").addResourceLocations("file:" + UrlUtil.win_productsecondtype);
            registry.addResourceHandler("/rollingpick/**").addResourceLocations("file:" + UrlUtil.win_rollingpick);
        } else {
            log.info("当前操作系统为linux");
            createDir(UrlUtil.linux_productdetail);
            createDir(UrlUtil.linux_productpics);
            createDir(UrlUtil.linux_productsecondtype);
            createDir(UrlUtil.linux_rollingpick);
            registry.addResourceHandler("/productdetail/**").addResourceLocations("file:" + UrlUtil.linux_productdetail);
            registry.addResourceHandler("/productpics/**").addResourceLocations("file:" + UrlUtil.linux_productpics);
            registry.addResourceHandler("/productsecondtype/**").addResourceLocations("file:" + UrlUtil.linux_productsecondtype);
            registry.addResourceHandler("/rollingpick/**").addResourceLocations("file:" + UrlUtil.linux_rollingpick);
            registry.addResourceHandler("/banner/**").addResourceLocations("file:"+UrlUtil.linux_banner);
        }
    }

    private void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            log.info("创建：" + path);
            boolean mkdir = file.mkdirs();
            if (!mkdir) {
                log.warn("创建：" + path + "失败");
            }
        }
    }
}
