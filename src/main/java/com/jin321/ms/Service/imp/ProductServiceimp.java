package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductService;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductdetailMapper;
import com.jin321.pl.dao.ProductpicsMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 货物服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceimp implements ProductService {
    private int signa;
    private int signb;
    private int signc;
    private int signd;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductsizeMapper productsizeMapper;
    @Autowired
    private ProductpicsMapper productpicsMapper;
    @Autowired
    private ProductdetailMapper productdetailMapper;
    private Productsize productsize;
    private Productpics productpics;
    private Productdetail productdetail;
    /**
     *
     * @param product 插入product对象
     * @return 1成功 0失败
     */
    @Override
    public int insertProduct(Product product,List<Productsize> productsizes) {
        signa=productMapper.insert(product);
        Iterator<Productsize> psit=productsizes.iterator();
        while(psit.hasNext()){
            productsize=psit.next();
            productsize.setPid(product.getPid());
            signb=productsizeMapper.insert(productsize);
            if(signb==0)
                break;
        }
        //设置默认图片
        productpics=new Productpics();
        productpics.setPid(product.getPid());
        productpics.setIsHeadpic(true);
        productpics.setPpicurl("\\productpics\\default.jpg");
        productpics.setIsDeleted(false);
        signc=productpicsMapper.insert(productpics);
        //设置默认详情
        productdetail=new Productdetail();
        productdetail.setIsDeleted(false);
        productdetail.setPorder(0);
        productdetail.setPid(product.getPid());
        productdetail.setPicurl("\\productdetail\\default.jpg");
        signd=productdetailMapper.insert(productdetail);
        return signa&signb&signc&signd;
    }
    private Product product;

    /**
     *
     * @param pid 要标记删除的商品ID号
     * @return 1成功 0失败 2商品不存在
     */
    @Override
    public int deleteProduct(int pid) {
        product=productMapper.selectByPrimaryKey(pid);
        if(product!=null){
            product.setIsDelete(true);
            return productMapper.updateByPrimaryKey(product);
        }
        else
            return 2;
    }

    /**
     *
     * @param product 更新后的商品数据
     * @return 1成功 0失败 2商品不存在
     */

    private Product productold;
    @Override
    public int updateProduct(Product product,List<Productsize> productsizes) {
        productold=productMapper.selectByPrimaryKey(product.getPid());
        Iterator<Productsize> iterator=productsizes.iterator();
        if(productold!=null){
            signa=productMapper.updateByPrimaryKey(product);
            while (iterator.hasNext()){
                signb=productsizeMapper.updateByPrimaryKey(iterator.next());
            }
            return signa&signb;
        }
        else
            return 2;
    }
}
