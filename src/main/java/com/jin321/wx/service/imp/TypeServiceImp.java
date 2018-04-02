package com.jin321.wx.service.imp;

import com.jin321.pl.dao.ProducttypeMapper;
import com.jin321.pl.model.Producttype;
import com.jin321.pl.model.ProducttypeExample;
import com.jin321.wx.dao.ProductPoMapper;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.TypeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/7 22:02
 * @Description :查询商品类别的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TypeServiceImp implements TypeService {
    private static final Log log = LogFactory.getLog(TypeServiceImp.class);
    @Autowired
    ProducttypeMapper producttypeMapper;
    @Autowired
    ProductPoMapper productPoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Producttype> selectAllFirstProducttype() throws Exception {
        ProducttypeExample producttypeExample = new ProducttypeExample();
        ProducttypeExample.Criteria criteria = producttypeExample.createCriteria();
        criteria.andTypeclassEqualTo(1);
        criteria.andIsDeleteEqualTo(false);
        List<Producttype> producttypes = producttypeMapper.selectByExample(producttypeExample);
        return producttypes;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Producttype> selectSecondProducttype(int tid) throws Exception {
        ProducttypeExample producttypeExample = new ProducttypeExample();
        ProducttypeExample.Criteria criteria = producttypeExample.createCriteria();
        criteria.andHighertidEqualTo(tid);
        criteria.andIsDeleteEqualTo(false);
        List<Producttype> producttypes = producttypeMapper.selectByExample(producttypeExample);
        return producttypes;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProductPo> selectProductByptypeb(int ptypec, String code) throws Exception {
        List<ProductPo> productPos = null;
        if (code.equals("0")) {
            log.debug("通过销量排序");
            productPos = productPoMapper.selectNowByPtypebByPsellnum(ptypec);
        } else {
            log.debug("通过价格排序");
            productPos = productPoMapper.selectNowByPtypebByPrice(ptypec);
        }
        return productPos;
    }
}
