package com.jin321.wx.service.imp;

import com.jin321.wx.dao.ProductPoMapper;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.SelectProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/14 16:23
 * @Description :关键字搜索商品
 */
@Service("selectProductService")
@Transactional(rollbackFor = Exception.class)
public class SelectProductServiceImp implements SelectProductService {
    private static final Log log = LogFactory.getLog(SelectProductServiceImp.class);
    @Autowired
    ProductPoMapper productPoMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProductPo> selectProductBykey(String key,String code) throws Exception {
        String trim = key.trim();
        List<ProductPo> productPos = null;
        if (code.equals("0")) {
            log.debug("通过销量排序");
           productPos  = productPoMapper.selectNowBykeyOrderByPsellnum(trim);
        } else {
            log.debug("通过价格排序");
            productPos = productPoMapper.selectNowBykeyOrderByPrice(trim);
        }


        return productPos;
    }
}
