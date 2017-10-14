package com.jin321.wx.service.imp;

import com.jin321.pl.dao.ProducttypeMapper;
import com.jin321.pl.model.Producttype;
import com.jin321.pl.model.ProducttypeExample;
import com.jin321.wx.dao.ProductPoMapper;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/7 22:02
 * @Description :查询商品类别的实现类
 */
@Service("typeService")
public class TypeServiceImp  implements TypeService {
    @Autowired
    ProducttypeMapper producttypeMapper;
    @Autowired
    ProductPoMapper productPoMapper;
    @Override
    public List<Producttype> selectAllFirstProducttype() throws Exception{
        ProducttypeExample producttypeExample = new ProducttypeExample();
        ProducttypeExample.Criteria criteria = producttypeExample.createCriteria();
        criteria.andTypeclassEqualTo(1);
        List<Producttype> producttypes = producttypeMapper.selectByExample(producttypeExample);
        return producttypes;
    }

    @Override
    public List<Producttype> selectSecondProducttype(int tid) throws Exception {
        ProducttypeExample producttypeExample = new ProducttypeExample();
        ProducttypeExample.Criteria criteria = producttypeExample.createCriteria();
        criteria.andHighertidEqualTo(tid);
        List<Producttype> producttypes = producttypeMapper.selectByExample(producttypeExample);
        return producttypes;
    }

    @Override
    public List<ProductPo> selectProductByptypeb(int ptypeb) throws Exception {
        List<ProductPo> productPos = productPoMapper.selectNowByPtypeb(ptypeb);
        return productPos;
    }
}
