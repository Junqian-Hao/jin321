package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductService;
import com.jin321.ms.dao.InsertProductMapper;
import com.jin321.ms.model.TrueProduct;
import com.jin321.pl.dao.*;
import com.jin321.pl.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 货物服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceimp implements ProductService {
    private static final Log log = LogFactory.getLog(ProductServiceimp.class);
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
    private InsertProductMapper insertProductMapper;
    @Autowired
    private ProductdetailMapper productdetailMapper;
    private Productsize productsize;
    private Productpics productpics;
    private Productdetail productdetail;

    /**
     * @param product 插入product对象
     * @return 1成功 0失败
     */
    @Override
    public int insertProduct(Product product, List<Productsize> productsizes) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andPnameEqualTo(product.getPname());
        if (productMapper.selectByExample(productExample).size() > 0)
            return -1;
        product.setIsTogether(false);
        //待修改未完成，此处应为2
        product.setIsDelete(0);
        log.debug("商品状态：" + product.getIsDelete());
        signa = insertProductMapper.insertProduct(product);
        Iterator<Productsize> psit = productsizes.iterator();
        while (psit.hasNext()) {
            productsize = psit.next();
            productsize.setPid(product.getPid());
            productsize.setIsDeleted(false);
            signb = productsizeMapper.insert(productsize);
            if (signb == 0)
                break;
        }
        //设置默认图片
        productpics = new Productpics();
        productpics.setPid(product.getPid());
        productpics.setIsHeadpic(true);
        productpics.setPpicurl("productpics/default.jpg");
        productpics.setIsDeleted(false);
        signc = productpicsMapper.insert(productpics);
        //设置默认详情
        productdetail = new Productdetail();
        productdetail.setIsDeleted(false);
        productdetail.setPorder(1);
        productdetail.setPid(product.getPid());
        productdetail.setPicurl("productdetail/default.jpg");
        signd = productdetailMapper.insert(productdetail);
        return signa & signb & signc & signd;
    }

    private Product product;

    /**
     * @param pids 要标记删除的商品ID号
     * @return 1成功 0失败 2商品不存在
     */
    @Override
    public int deleteProduct(List<Integer> pids) {
        int pid;
        Iterator<Integer> iterator = pids.iterator();
        while (iterator.hasNext()) {
            pid = iterator.next();
            product = productMapper.selectByPrimaryKey(pid);
            if (product != null) {
                product.setIsDelete(1);
                productMapper.updateByPrimaryKey(product);
            } else {
                return 0;
            }
        }
        return 1;
    }

    /**
     * @param product 更新后的商品数据
     * @return 1成功 0失败 2商品不存在
     */

    private Product productold;

    @Override
    public int updateProduct(Product product, List<Productsize> productsizes) {
        productold = productMapper.selectByPrimaryKey(product.getPid());
        Iterator<Productsize> iterator = productsizes.iterator();
        if (productold != null) {
            signa = productMapper.updateByPrimaryKey(product);
            while (iterator.hasNext()) {
                signb = productsizeMapper.updateByPrimaryKey(iterator.next());
            }
            return signa & signb;
        } else
            return 2;
    }

    private int pid;
    private int sign;

    /**
     * 增加合伙商品
     *
     * @param pids
     * @return -1无此商品 0更新失败 1设置成功
     */
    @Override
    public int setTogetherProduct(List<String> pids) {
        Iterator<String> iterator = pids.iterator();
        while (iterator.hasNext()) {
            pid = Integer.parseInt(iterator.next());
            product = productMapper.selectByPrimaryKey(pid);
            if (product == null)
                return -1;
            product.setIsTogether(true);
            if (productMapper.updateByPrimaryKey(product) != 0)
                sign = 1;
            else
                return 0;
        }
        return sign;
    }

    /**
     *
     * @param pids
     * @return 0失败 1成功 -1无此商品
     */
    @Override
    public int deleteTogetherProduct(List<String> pids) {
        Iterator<String> iterator = pids.iterator();
        while (iterator.hasNext()) {
            pid = Integer.parseInt(iterator.next());
            log.debug("删除的商品id"+pid);
            product = productMapper.selectByPrimaryKey(pid);
            if (product == null)
                return -1;
            else {
                product.setIsTogether(false);
                if (productMapper.updateByPrimaryKey(product) != 0)
                    sign = 1;
                else
                    return 0;
            }
        }
        return sign;
    }

    @Autowired
    private ProducttypeMapper producttypeMapper;
    private TrueProduct trueProduct;
    private List<Product> productList;
    private List<TrueProduct> trueProductList;
    private String ptypea;
    private String ptypeb;

    /**
     * @param did 查询的商家编号
     * @return 真·商品
     */
    @Override
    public List<TrueProduct> selectProductByDealer(int did) {
        trueProductList = new ArrayList<TrueProduct>();
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andDidEqualTo(did);
        productList = productMapper.selectByExample(example);
        Iterator<Product> it = productList.iterator();

        while (it.hasNext()) {
            product = it.next();
            if (product != null) {
                trueProduct = new TrueProduct();
                trueProduct.setDelete(product.getIsDelete());
                trueProduct.setDid(product.getDid());
                trueProduct.setPid(product.getPid());
                trueProduct.setPname(product.getPname());
                trueProduct.setPsellnum(product.getPsellnum());
                trueProduct.setPsummary(product.getPsummary());
                trueProduct.setTogether(product.getIsTogether());
                ptypea = producttypeMapper.selectByPrimaryKey(product.getPtypea()).getTypename();
                ptypeb = producttypeMapper.selectByPrimaryKey(product.getPtypeb()).getTypename();
                trueProduct.setPtypea(ptypea);
                trueProduct.setPtypeb(ptypeb);
                trueProductList.add(trueProduct);
            }
        }
        return trueProductList;
    }

    /**
     * @param ptypea 第一分类
     * @param ptypeb 第二分类
     * @return 1 成功 0失败 -1 无此分类
     */
    @Override
    public int updateProductType(int pid, int ptypea, int ptypeb) {
        product = productMapper.selectByPrimaryKey(pid);
        product.setPtypea(ptypea);
        product.setPtypeb(ptypeb);
        if (producttypeMapper.selectByPrimaryKey(ptypea) != null &&
                producttypeMapper.selectByPrimaryKey(ptypeb) != null) {
            return productMapper.updateByPrimaryKey(product);
        }
        return -1;
    }

    @Override
    public List<Product> getReadyProduct() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(2);
        productList = productMapper.selectByExample(example);
        return productList;
    }

    /**
     * @param pid
     * @param check
     * @return 0为拒绝 1为通过
     */

    @Override
    public int checkoutProduct(int pid, int check) {
        product = productMapper.selectByPrimaryKey(pid);
        if (product != null) {
            if (check == 0)
                product.setIsDelete(3);
            else
                product.setIsDelete(0);
            signa = productMapper.updateByPrimaryKey(product);
        }
        return signa;
    }
}


