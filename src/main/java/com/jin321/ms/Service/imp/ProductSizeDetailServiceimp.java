package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.dao.GetProductSizeDetailMapper;
import com.jin321.ms.model.Page;
import com.jin321.ms.model.UpdateProductSizeDetail;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.model.ProductsizeExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :
 */
@Service
public class ProductSizeDetailServiceimp implements ProductSizeDetailService {
    private static final Log log = LogFactory.getLog(ProductSizeDetailServiceimp.class);
    @Autowired
    private GetProductSizeDetailMapper getProductSizeDetailMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductsizeMapper productsizeMapper;
    private Product product;
    private Productsize productsize;
    private List<UpdateProductSizeDetail> productSizeDetailList;

    private Page<UpdateProductSizeDetail> productSizeDetailPage;
    @Override
    public Page<UpdateProductSizeDetail> getDetailBydid(int pagenum,int thispage,int did) {
        productSizeDetailList=getProductSizeDetailMapper.getProductSizeDetail(did);
        productSizeDetailPage=new Page<UpdateProductSizeDetail>().getPageList(pagenum,thispage,productSizeDetailList);
        return productSizeDetailPage;
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
    private int sid;

    /**
     * 删除商品款式接口
     * @param sidlist 款式id
     * @return 1 成功删除 0 删除失败 -1无此款式 2无商品
     */
    @Override
    public int deleteDetail(List<String> sidlist) {
        Iterator<String> iterator=sidlist.iterator();
        while (iterator.hasNext()) {
            sid= Integer.parseInt(iterator.next());
            log.debug("获取到的sid为:"+sid);
            productsize=productsizeMapper.selectByPrimaryKey(sid);
            sign=productsizeMapper.updateByPrimaryKey(productsize);
            if(productsize!=null){
                ProductsizeExample example=new ProductsizeExample();
                ProductsizeExample.Criteria criteria=example.createCriteria();
                criteria.andPidEqualTo(productsize.getPid());
                criteria.andIsDeletedEqualTo(false);
                productsize.setIsDeleted(true);
                sign=productsizeMapper.updateByPrimaryKey(productsize);
                if(productsizeMapper.selectByExample(example).size()==0){
                    product=productMapper.selectByPrimaryKey(productsize.getPid());
                    if (product!=null){
                        product.setIsDelete(1);
                        productMapper.updateByPrimaryKey(product);
                    }
                    else
                        return 2;
                }
            }else
                return -1;

        }
      return sign;
    }
}
