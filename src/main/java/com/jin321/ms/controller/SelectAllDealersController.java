package com.jin321.ms.controller;

import com.jin321.ms.Service.DealerService;
import com.jin321.pl.model.Dealer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/9.
 *
 * @Description : 查询所有经销商接口
 */
@Controller
@RequestMapping("/ms")
public class SelectAllDealersController {
    private static final Log log = LogFactory.getLog(SelectAllDealersController.class);
    @Autowired
    private DealerService dealerMapper;
    @ResponseBody
    @RequestMapping("/selectAllDealer")
    public List<Dealer> selectAllDealer(){
        log.info("查询所有商家");
        return dealerMapper.selectAllDealer();
    }
}
