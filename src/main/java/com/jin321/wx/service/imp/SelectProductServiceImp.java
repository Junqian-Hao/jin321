package com.jin321.wx.service.imp;

import com.jin321.wx.dao.ProductPoMapper;
import com.jin321.wx.model.ProductPo;
import com.jin321.wx.service.SelectProductService;
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
public class SelectProductServiceImp implements SelectProductService {

    @Autowired
    ProductPoMapper productPoMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProductPo> selectProductBykey(String key) throws Exception {
        String trim = key.trim();
        List<ProductPo> productPos = productPoMapper.selectNowBykey(trim);
        return productPos;
    }
}
