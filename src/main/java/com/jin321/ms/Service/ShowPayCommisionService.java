package com.jin321.ms.Service;

import com.jin321.ms.model.Page;
import com.jin321.pl.model.Paycommision;


public interface ShowPayCommisionService {
    public Page<Paycommision> getAllPaycommision(int pagenum,int thispage);
}
