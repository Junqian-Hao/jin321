package com.jin321.wx.controller;

import com.jin321.pl.model.District;
import com.jin321.wx.service.DistrictService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/8 21:01
 * @Description :行政区联动
 */
@Controller
@RequestMapping("/wx")
public class DistrictController {
    private static final Log log = LogFactory.getLog(DistrictController.class);
    @Autowired
    DistrictService districtService;

    /**
     * 查询行政区划 国家-1
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectNextDistrict")
    @ResponseBody
    public List<District> selectNextDistrict(@RequestBody Map<String, String> re) throws Exception {
        log.info("行政区划查询");
        String cpaid = re.get("cid");
        List<District> districts = districtService.selectNextDistrict(Integer.parseInt(cpaid));
        return districts;
    }
}
