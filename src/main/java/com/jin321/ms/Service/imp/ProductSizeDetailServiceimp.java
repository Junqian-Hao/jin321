package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.dao.GetProductSizeDetailMapper;
import com.jin321.ms.model.UpdateProductSizeDetail;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.model.ProductsizeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
@Service
public class ProductSizeDetailServiceimp implements ProductSizeDetailService {
    @Autowired
    private GetProductSizeDetailMapper getProductSizeDetailMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductsizeMapper productsizeMapper;
    private Product product;
    private Productsize productsize;
    private List<UpdateProductSizeDetail> productSizeDetailList;

    @Override
    public List<UpdateProductSizeDetail> getDetailBydid(int did) {
        productSizeDetailList = getProductSizeDetailMapper.getProductSizeDetail(did);
        return productSizeDetailList;
    }

    /**
     * 修改商品详细信息接口
     * @param updateProductSizeDetail
     * @return
     */
    @Override
    public int updateDetail(UpdateProductSizeDetail updateProductSizeDetail) {
        product=productMapper.selectByPrimaryKey(updateProductSizeDetail.getPid());
        productsize=productsizeMapper.selectByPrimaryKey(updateProductSizeDetail.getSid());
        if(product!=null&&productsize!=null){
            product.setPname(updateProductSizeDetail.getPname());
            productsize.setPsoriprice(updateProductSizeDetail.getPsoriprice());
            productsize.setPssellprice(updateProductSizeDetail.getPssellprice());
            productsize.setSizename(updateProductSizeDetail.getSizename());
            productsize.setSnumber(updateProductSizeDetail.getSnumber());
            return productsizeMapper.updateByPrimaryKey(productsize)&
                    productMapper.updateByPrimaryKey(product);
        }
        else
            return -1;
    }
    private int sign;

    /**
     * 删除商品款式接口
     * @param sid 款式id
     * @return 1 成功删除 0 删除失败 -1无此款式 4商品无款式自动删除 5无款式对应商品
     */
    @Override
    public int deleteDetail(int sid) {
        productsize=productsizeMapper.selectByPrimaryKey(sid);
        if(productsize!=null){
            ProductsizeExample example=new ProductsizeExample();
            ProductsizeExample.Criteria criteria=example.createCriteria();
            criteria.andPidEqualTo(productsize.getPid());
            if(productsizeMapper.selectByExample(example).size()==0){
                sign=productMapper.deleteByPrimaryKey(productsize.getPid());
                if (sign==1){
                    productsizeMapper.deleteByPrimaryKey(sid);
                    return 4;
                }
                else
                    return 5;
            }
            return productsizeMapper.deleteByPrimaryKey(sid);
        }
        return -1;
    }
}
