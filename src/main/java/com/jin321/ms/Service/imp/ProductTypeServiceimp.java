package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductTypeService;
import com.jin321.pl.dao.ProducttypeMapper;

import com.jin321.pl.model.Producttype;
import com.jin321.pl.model.ProducttypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/5.
 *
 * @Description :
 */
@Service
public class ProductTypeServiceimp implements ProductTypeService {
    @Autowired
    private ProducttypeMapper producttypeMapper;
    private Producttype producttype;
    /**
     *
     * @param producttype
     * @return 插入一级标签服务
     */
    @Override
    public int insertFirstType(Producttype producttype) {
        ProducttypeExample producttypeExample=new ProducttypeExample();
        ProducttypeExample.Criteria criteria=producttypeExample.createCriteria();
        criteria.andTypenameEqualTo(producttype.getTypename());
        criteria.andTypeclassEqualTo(1);
        if(producttypeMapper.selectByExample(producttypeExample).size()>0){
            return -1;
        }
        producttype.setIsDelete(false);
        producttype.setTypeclass(1);
        return insertFirstType(producttype);
    }

    @Override
    public int insertSecondType(Producttype producttype) {
        ProducttypeExample producttypeExample=new ProducttypeExample();
        ProducttypeExample.Criteria criteria=producttypeExample.createCriteria();
        criteria.andTypenameEqualTo(producttype.getTypename());
        criteria.andTypeclassEqualTo(2);
        if(producttypeMapper.selectByExample(producttypeExample).size()>0){
            return -1;
        }
        producttype.setIsDelete(false);
        producttype.setTypeclass(2);
        return insertFirstType(producttype);
    }
    private List<Producttype> secondbyfirsttidlist;
    @Override
    public int deleteFirstType(int tid) {
        if(producttypeMapper.selectByPrimaryKey(tid)==null){
            return -1;
        }
        if(producttypeMapper.deleteByPrimaryKey(tid)==0)
            return 0;
        //删除一级分类下二级分类
        ProducttypeExample producttypeExample=new ProducttypeExample();
        ProducttypeExample.Criteria criteria=producttypeExample.createCriteria();
        criteria.andHighertidEqualTo(tid);
        secondbyfirsttidlist=producttypeMapper.selectByExample(producttypeExample);
        Iterator<Producttype> iterator=secondbyfirsttidlist.iterator();
        while (iterator.hasNext()){
            producttype=iterator.next();
            if (producttypeMapper.deleteByPrimaryKey(producttype.getTid())!=1) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteSecondType(int tid) {
        producttype=producttypeMapper.selectByPrimaryKey(tid);
       if(producttype!=null){
           return producttypeMapper.deleteByPrimaryKey(tid);
       }
       else
           return -1;
    }
}
