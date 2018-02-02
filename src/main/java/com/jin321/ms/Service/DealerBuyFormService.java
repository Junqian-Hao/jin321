package com.jin321.ms.Service;

import javax.transaction.Transactional;

public interface DealerBuyFormService {
    public int changeFormState(int dbfid,int state);
}
