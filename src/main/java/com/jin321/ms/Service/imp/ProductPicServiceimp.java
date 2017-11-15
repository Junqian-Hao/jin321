package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductPicService;
import com.jin321.pl.dao.ProductpicsMapper;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.ProductpicsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 商品图片相关
 */
@Service
public class ProductPicServiceimp implements ProductPicService {
    @Autowired
    private ProductpicsMapper productpicsMapper;
    private List<Productpics> productpicsold;

    @Override
    public int productPicUpdate(Productpics productpics) {
        productpics.setIsHeadpic(false);
        return productpicsMapper.insert(productpics);
    }

    @Override
    public int productHeadPicService(Productpics productpics) {
        productpics.setIsHeadpic(true);
        return productpicsMapper.insert(productpics);
    }

    @Override
    public int productPicDelete(List<Integer> productpicsList) {
        Iterator<Integer> iterator = productpicsList.iterator();
        while (iterator.hasNext()) {
            int ppid = iterator.next();
            productpics = productpicsMapper.selectByPrimaryKey(ppid);
            productpics.setIsDeleted(true);
            if (productpicsMapper.updateByPrimaryKey(productpics) == 0)
                return 0;
        }
        return 1;
    }

    private Productpics productpics;
    @Override
    public void productNoHeadPicDelete(int pid,String RealPath) {
        ProductpicsExample productpicsExample = new ProductpicsExample();
        ProductpicsExample.Criteria criteria = productpicsExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        criteria.andPidEqualTo(pid);
        productpicsold = productpicsMapper.selectByExample(productpicsExample);
        Iterator<Productpics> iterator = productpicsold.iterator();
        while (iterator.hasNext()) {
            productpics = iterator.next();
            productpics.setIsDeleted(true);
            productpicsMapper.updateByPrimaryKey(productpics);
        }
    }

    @Override
    public List<Productpics> selectProductPicNow(int pid) {
        ProductpicsExample productpicsExample = new ProductpicsExample();
        ProductpicsExample.Criteria criteria = productpicsExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        criteria.andPidEqualTo(pid);
        productpicsold = productpicsMapper.selectByExample(productpicsExample);
        return productpicsold;
    }
}
