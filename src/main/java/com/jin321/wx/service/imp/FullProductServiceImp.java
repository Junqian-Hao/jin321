package com.jin321.wx.service.imp;

import com.jin321.wx.dao.FullProductMapper;
import com.jin321.wx.model.FullProduct;
import com.jin321.wx.service.FullProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author hao
 * @Date 2017/10/2 16:35
 * @Description :查询商品详细信息的实现
 */
@Service("fullProductService")
public class FullProductServiceImp implements FullProductService{
    @Autowired
    FullProductMapper fullProductMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FullProduct selectFullProductById(int pid) {
        FullProduct fullProduct = fullProductMapper.selectFullProductById(pid);
        return fullProduct;
    }
}
