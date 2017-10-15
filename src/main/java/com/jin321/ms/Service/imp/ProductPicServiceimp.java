package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductPicService;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductpicsMapper;
import com.jin321.pl.model.ProductExample;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.ProductpicsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 商品图片相关
 */
@Service
public class ProductPicServiceimp implements ProductPicService {
    @Autowired
    private ProductpicsMapper productpicsMapper;
    private Productpics productpicsold;
    @Override
    public int productPicUpdate(Productpics productpics) {
        ProductpicsExample productpicsExample=new ProductpicsExample();
        ProductpicsExample.Criteria criteria=productpicsExample.createCriteria();
        criteria.andPidEqualTo(productpics.getPid());
        criteria.andIsDeletedEqualTo(false);
        productpicsold=productpicsMapper.selectByExample(productpicsExample).get(0);
        if(productpicsold.getPpicurl().contains("default")){
            productpicsold.setIsDeleted(true);
            productpicsMapper.updateByPrimaryKey(productpicsold);
            productpics.setIsHeadpic(true);
        }else
            productpics.setIsHeadpic(false);
        return productpicsMapper.insert(productpics);
    }

}
