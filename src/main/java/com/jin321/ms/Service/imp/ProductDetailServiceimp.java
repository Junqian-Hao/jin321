package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductDetailService;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductdetailMapper;
import com.jin321.pl.model.Productdetail;
import com.jin321.pl.model.ProductdetailExample;
import com.jin321.wx.model.ProductsizeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 添加图书详情图片
 */
@Service
public class ProductDetailServiceimp implements ProductDetailService {
    @Autowired
    private ProductdetailMapper productdetailMapper;
    private List<Productdetail> productdetailList;
    private Productdetail productdetailold;
    @Override
    public int productDetailUpdate(Productdetail productdetail) {
        ProductdetailExample productdetailExample=new ProductdetailExample();
        ProductdetailExample.Criteria criteria=productdetailExample.createCriteria();
        criteria.andPidEqualTo(productdetail.getPid());
        criteria.andIsDeletedEqualTo(false);
        productdetailList=productdetailMapper.selectByExample(productdetailExample);
        productdetailold=productdetailList.get(0);
        productdetail.setPorder(productdetailList.size()+1);
        return productdetailMapper.insert(productdetail);
    }
    private List<Productdetail> productdetailsold;

    @Override
    public void productDetailDelete(int pid) {
        ProductdetailExample example=new ProductdetailExample();
        ProductdetailExample.Criteria criteria=example.createCriteria();
        criteria.andPidEqualTo(pid);
        productdetailsold=productdetailMapper.selectByExample(example);
        Iterator<Productdetail> iterator=productdetailsold.iterator();
        while(iterator.hasNext()){
            productdetailold=iterator.next();
            productdetailMapper.deleteByPrimaryKey(productdetailold.getPdid());
        }
    }
}
