package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.AboutUsService;
import com.jin321.pl.dao.AboutusMapper;
import com.jin321.pl.model.Aboutus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutUsServiceimp implements AboutUsService {
    @Autowired
    private AboutusMapper aboutusMapper;
    @Override
    public int updateaboutus(String text) {
        Aboutus aboutus=new Aboutus();
        aboutus.setDetail(text);
        return aboutusMapper.insert(aboutus);
    }
}
