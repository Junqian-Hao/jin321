package com.jin321.wx.controller;

import com.jin321.pl.model.Chart;
import com.jin321.pl.utils.UrlUtil;
import com.jin321.wx.model.DealerDetail;
import com.jin321.wx.service.ChartService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2017/10/6 11:40
 * @Description :购物车控制器
 */
@Controller
@RequestMapping("/wx")
public class ChartController {
        private static final Log log = LogFactory.getLog(ChartController.class);
    @Autowired
    ChartService chartService;

    /**
     * 添加购物车
     * @param chart
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertChart")
    @ResponseBody
    public Map<String, Object> insertChart(@RequestBody Chart chart) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info(chart.getUid()+"插入购物车");
        boolean b = chartService.insertChart(chart);
        if (b) {
            map.put("code", 1);
            map.put("message", "插入成功");
            return map;
        } else {
            map.put("code", 0);
            map.put("message", "插入失败");
            return map;
        }
    }

    /**
     * 删除购物车
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteChart")
    @ResponseBody
    public Map<String, Object> deleteChart(@RequestBody Map<String, String> re) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info("删除购物车->"+re.get("chartid"));
        boolean b = chartService.deleteChart(Integer.parseInt(re.get("chartid")));
        if (b) {
            map.put("code", 1);
            map.put("message", "删除成功");
            return map;
        } else {
            map.put("code", 0);
            map.put("message", "删除失败");
            return map;
        }
    }

    /**
     * 修改购物车商品数量
     * @param re
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateChartPnumber")
    @ResponseBody
    public Map<String, Object> updateChartPnumber(@RequestBody Map<String, String> re) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info("修改购物车->"+re.get("chartid"));
        boolean b = chartService.updateChartPnumber(Integer.parseInt(re.get("chartid")),Integer.parseInt(re.get("pnumber")));
        if (b) {
            map.put("code", 1);
            map.put("message", "修改成功");
            return map;
        } else {
            map.put("code", 0);
            map.put("message", "修改失败");
            return map;
        }
    }

    /**
     * 通过用户id查询用户购物车
     * @param re
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectChartByUserId")
    @ResponseBody
    public Map<String, Object> selectChartByUserId(@RequestBody Map<String, String> re, HttpServletRequest request) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info("查询购物车信息购物车->"+re.get("uid"));
        List<DealerDetail> uid = chartService.selectChartByUserId(re.get("uid"));
        map.put("baseUrl", UrlUtil.getBasePathNoPort(request));
        if (uid == null) {
            uid = new ArrayList<>();
        }
        map.put("chartDetail", uid);
        return map;
    }
}
