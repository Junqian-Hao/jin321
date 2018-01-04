package com.jin321.wx.service.imp;

import com.jin321.pl.dao.ProductpicsMapper;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.ProductpicsExample;
import com.jin321.wx.dao.FullProductMapper;
import com.jin321.wx.model.FullProduct;
import com.jin321.wx.service.FullProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/2 16:35
 * @Description :查询商品详细信息的实现
 */
@Service("fullProductService")
public class FullProductServiceImp implements FullProductService{
    private static final Log log = LogFactory.getLog(FullProductServiceImp.class);
    @Autowired
    FullProductMapper fullProductMapper;
    @Autowired
    ProductpicsMapper productpicsMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FullProduct selectFullProductById(int pid) {
        FullProduct fullProduct = fullProductMapper.selectFullProductById(pid);
        return fullProduct;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String selectHeadpicsByPid(int pid) {
        ProductpicsExample productpicsExample = new ProductpicsExample();
        ProductpicsExample.Criteria criteria = productpicsExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        criteria.andPidEqualTo(pid);
        criteria.andIsHeadpicEqualTo(true);
        List<Productpics> productpics = productpicsMapper.selectByExample(productpicsExample);
        if (productpics != null && productpics.size() > 0) {
            return productpics.get(0).getPpicurl();
        }
        return null;
    }
}
