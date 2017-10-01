package com.jin321.ms.model;

import com.jin321.pl.model.Dealer;

/**
 * Created by Tyranitarx on 2017/9/30.
 * @Description :经销商
 */
public class DealerLogin extends Dealer {
    private String dusername;
    private String dpassword;

    @Override
    public String getDusername() {
        return dusername;
    }

    @Override
    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    @Override
    public String getDpassword() {
        return dpassword;
    }

    @Override
    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }
}
