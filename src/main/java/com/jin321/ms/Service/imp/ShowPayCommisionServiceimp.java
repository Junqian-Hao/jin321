package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ShowPayCommisionService;
import com.jin321.ms.model.Page;
import com.jin321.pl.dao.PaycommisionMapper;
import com.jin321.pl.model.Paycommision;
import com.jin321.pl.model.PaycommisionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowPayCommisionServiceimp implements ShowPayCommisionService{
    @Autowired
    private PaycommisionMapper paycommisionMapper;
    @Override
    public Page<Paycommision> getAllPaycommision(int pagenum,int thispage) {
        PaycommisionExample example=new PaycommisionExample();
        return new Page<Paycommision>().getPageList(pagenum,thispage,paycommisionMapper.selectByExample(example));
    }
}
