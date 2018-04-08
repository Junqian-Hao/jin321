package com.jin321.wx.service.imp;

import com.jin321.pl.dao.AboutusMapper;
import com.jin321.pl.model.Aboutus;
import com.jin321.pl.model.AboutusExample;
import com.jin321.wx.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hao
 * @Date: 2018/3/25 20:38
 * @Description: 关于我们
 */
@Service
@CacheConfig(cacheNames = "aboutUs")
public class AboutUsServiceImp implements AboutUsService {
    @Autowired
    AboutusMapper aboutusMapper;
    @Override
    @Cacheable
    public Aboutus findfirstboutUs() {
        List<Aboutus> aboutuses = aboutusMapper.selectByExample(new AboutusExample());
        if (aboutuses == null) {
            return new Aboutus();
        }
        if (aboutuses.size() == 0) {
            return aboutuses.get(0);
        }
        return aboutuses.get(aboutuses.size()-1);
    }
}
