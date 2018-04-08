package com.jin321.wx.service.imp;

import com.jin321.pl.dao.DistrictMapper;
import com.jin321.pl.model.District;
import com.jin321.pl.model.DistrictExample;
import com.jin321.wx.service.DistrictService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/8 20:57
 * @Description :行政区划查询
 */
@Service
@CacheConfig(cacheNames = "district")
@Transactional(rollbackFor = Exception.class)
public class DistrictServiceImp implements DistrictService {
    private static final Log log = LogFactory.getLog(DistrictServiceImp.class);
    @Autowired
    DistrictMapper districtMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Cacheable
    public List<District> selectNextDistrict(int cpaid) throws Exception {
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andCPaIdEqualTo(cpaid);
        List<District> districts = districtMapper.selectByExample(districtExample);
        return districts;
    }
}
