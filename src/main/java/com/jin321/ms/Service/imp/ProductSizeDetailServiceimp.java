package com.jin321.ms.Service.imp;

import com.jin321.ms.Service.ProductSizeDetailService;
import com.jin321.ms.controller.CaptchaController;
import com.jin321.ms.dao.GetProductSizeDetailMapper;
import com.jin321.ms.model.TrueUpdateProductSizeDetail;
import com.jin321.ms.model.UpdateProductSizeDetail;
import com.jin321.pl.dao.ProductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.dao.ProducttypeMapper;
import com.jin321.pl.model.Product;
import com.jin321.pl.model.Productsize;
import com.jin321.pl.model.ProductsizeExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProducttypeMapper producttypeMapper;
    private Product product;
    private Productsize productsize;
    private UpdateProductSizeDetail updateProductSizeDetail;
    private List<UpdateProductSizeDetail> productSizeDetailList;
    private TrueUpdateProductSizeDetail trueUpdateProductSizeDetail;
    private List<TrueUpdateProductSizeDetail> trueUpdateProductSizeDetails;


    @Override
    public List<TrueUpdateProductSizeDetail> getDetailBydid(int did) {
        trueUpdateProductSizeDetails=new ArrayList<TrueUpdateProductSizeDetail>();
        productSizeDetailList=getProductSizeDetailMapper.getProductSizeDetail(did);
        Iterator iterator=productSizeDetailList.iterator();
        while (iterator.hasNext()){
            trueUpdateProductSizeDetail=new TrueUpdateProductSizeDetail();
            updateProductSizeDetail= (UpdateProductSizeDetail)iterator.next();
            trueUpdateProductSizeDetail.setPid(updateProductSizeDetail.getPid());
            trueUpdateProductSizeDetail.setPname(updateProductSizeDetail.getPname());
            trueUpdateProductSizeDetail.setPsoriprice(updateProductSizeDetail.getPsoriprice());
            trueUpdateProductSizeDetail.setPssellprice(updateProductSizeDetail.getPssellprice());
            trueUpdateProductSizeDetail.setPsummary(updateProductSizeDetail.getPsummary());
            trueUpdateProductSizeDetail.setSid(updateProductSizeDetail.getSid());
            trueUpdateProductSizeDetail.setSizename(updateProductSizeDetail.getSizename());
            trueUpdateProductSizeDetail.setSnumber(updateProductSizeDetail.getSnumber());
            trueUpdateProductSizeDetail.setPtypea(producttypeMapper.selectByPrimaryKey(updateProductSizeDetail.getPtypea()).getTypename());
            trueUpdateProductSizeDetail.setPtypeb(producttypeMapper.selectByPrimaryKey(updateProductSizeDetail.getPtypeb()).getTypename());
            trueUpdateProductSizeDetail.setPtypec(producttypeMapper.selectByPrimaryKey(updateProductSizeDetail.getPtypec()).getTypename());
            trueUpdateProductSizeDetails.add(trueUpdateProductSizeDetail);
        }
        return trueUpdateProductSizeDetails;
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
            if(productsize!=null){
                productsize.setIsDeleted(true);
                ProductsizeExample example=new ProductsizeExample();
                ProductsizeExample.Criteria criteria=example.createCriteria();
                criteria.andPidEqualTo(productsize.getPid());
                if(productsizeMapper.selectByExample(example).size()==0){
                    product=productMapper.selectByPrimaryKey(productsize.getPid());
                    if (product!=null){
                        product.setIsDelete(1);
                        productMapper.updateByPrimaryKey(product);
                        sign=productsizeMapper.updateByPrimaryKey(productsize);
                    }
                    else
                        return 2;
                }
                sign=productsizeMapper.updateByPrimaryKey(productsize);
            }else
                return -1;

        }
        return sign;
    }
}
