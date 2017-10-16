package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductDetailService;
import com.jin321.pl.dao.ProductdetailMapper;
import com.jin321.pl.model.Productdetail;
import com.jin321.pl.model.ProductdetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(productdetailold.getPicurl().contains("default")){
            productdetailold.setIsDeleted(true);
            productdetailMapper.updateByPrimaryKey(productdetailold);
            productdetail.setPorder(0);
        }else {
            productdetail.setPorder(productdetailList.size()+1);
        }
        return productdetailMapper.insert(productdetail);
    }
}
