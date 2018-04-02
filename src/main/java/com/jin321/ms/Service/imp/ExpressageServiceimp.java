package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ExpressageService;
import com.jin321.pl.dao.ExpressageMapper;
import com.jin321.pl.model.Expressage;
import com.jin321.pl.model.ExpressageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpressageServiceimp implements ExpressageService {
    @Autowired
    private ExpressageMapper expressageMapper;
    @Override
    public List<Expressage> getExpressage() {
        ExpressageExample expressageExample=new ExpressageExample();
        return expressageMapper.selectByExample(expressageExample);
    }
}
