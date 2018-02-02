package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.DealerBuyFormService;
import com.jin321.pl.dao.DealerbuyformMapper;
import com.jin321.pl.model.Dealerbuyform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DealerBuyFormServiceImp implements DealerBuyFormService {
    @Autowired
    private DealerbuyformMapper dealerbuyformMapper;
    private Dealerbuyform dealerbuyform;
    @Override
    public int changeFormState(int dbfid, int state) {
        dealerbuyform=dealerbuyformMapper.selectByPrimaryKey(dbfid);
        if(dealerbuyform==null){
            return -1;
        }
        dealerbuyform.setBuyformstate(state);
        if(state==1)
            dealerbuyform.setFormsenddate(new Date());
        else
            dealerbuyform.setFormcomfirmdate(new Date());
        return dealerbuyformMapper.updateByPrimaryKey(dealerbuyform);
        }
}
