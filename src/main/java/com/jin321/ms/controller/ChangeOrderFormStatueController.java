package com.jin321.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jin321.ms.Service.DealerService;
import com.jin321.ms.Service.OrderFormService;
import com.jin321.ms.model.DealerSellProductDetail;
import com.jin321.ms.model.OrderFormDetails;
import com.jin321.ms.model.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Tyranitarx on 2017/11/6.
 *
 * @Description :改变订单状态接口 样例参数{
 *      "oid":"xxx",
 *      "ostate":"ostate"
 * }
 */
@Controller
@RequestMapping("/ms")
public class ChangeOrderFormStatueController {
    private static final Log log = LogFactory.getLog(ChangeOrderFormStatueController.class);
    @Autowired
    private OrderFormService orderFormService;
    private Long oid;
    private String osendmethod;
    private String osendnumber;
    private int sign;
    private List<OrderFormDetails> orderFormDetailsList;
    private Map<String,Object> returnMap;
    @ResponseBody
    @RequestMapping("/getOrderform")
    public Map<String,Object> getOrderForm(@RequestBody String json, HttpServletRequest request){
        //未发货1 未确认2 确认4
        returnMap=new LinkedHashMap<String,Object>();
        JSONObject object=JSON.parseObject(json);
        int select=object.getInteger("select");
        int pagenum=object.getInteger("pagenum");
        int thispage=object.getInteger("thispage");
        int did=(Integer)request.getSession().getAttribute("did");
        Page<OrderFormDetails> orderFormDetailsPage=null;
        switch (select){
            case 1:
                orderFormDetailsPage=orderFormService.getUnReadyOrderfrom(did,pagenum,thispage);
                orderFormDetailsList =orderFormDetailsPage.getObjectList();break;
            case 2:
                orderFormDetailsPage=orderFormService.getReadyOrderform(did,pagenum,thispage);
                orderFormDetailsList =orderFormDetailsPage.getObjectList();break;
            case 3:
                orderFormDetailsPage=orderFormService.getconfirmForm(did,pagenum,thispage);
                orderFormDetailsList =orderFormDetailsPage.getObjectList();break;
        }
            if(orderFormDetailsList!=null){
                returnMap.put("pagenum",orderFormDetailsList.size());
                returnMap.put("thispage",orderFormDetailsPage.getThispage());
                returnMap.put("totalpage",orderFormDetailsPage.getTotalpage());
                returnMap.put("pagedata",orderFormDetailsList);
                return returnMap;
            }
            else {
                returnMap.put("error","页信息错误，或不存在订单");
                return returnMap;
            }
    }
    //发货接口
    @ResponseBody
    @RequestMapping("/changeOrderStatue")
    public Map<String,Object> changeStatue(@RequestBody String json){
        log.info("改变订单状态");
        returnMap=new HashMap<String, Object>();
        JSONObject object= JSON.parseObject(json);
        oid=(Long) object.get("oid");
        osendmethod=object.getString("osendmethod");
        osendnumber=object.getString("osendnumber");
        sign=orderFormService.sendOrderFormStatue(oid,osendmethod,osendnumber);
        if(sign==-1){
            returnMap.put("code","-1");
            returnMap.put("msg","此订单不存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code","0");
            returnMap.put("msg","修改失败");
            return returnMap;
        }
        else{
            returnMap.put("code","1");
            returnMap.put("msg","修改成功");
            return returnMap;
        }
    }
    @Autowired
    private DealerService dealerService;
    @ResponseBody
    @RequestMapping("/getDealerSellDetail")
    public Map<String,Object> getDealerSellDetail(@RequestBody String json){
        returnMap=new LinkedHashMap<>();
        JSONObject object=JSON.parseObject(json);
        int thispage=object.getInteger("thispage");
        int pagenum=object.getInteger("pagenum");
        int did=object.getInteger("did");
        Page<DealerSellProductDetail> dealerSellProductDetailPage=dealerService.getAllDealerOrderDetail(pagenum,thispage,did);
        List<DealerSellProductDetail> dealerSellProductDetails=dealerSellProductDetailPage.getObjectList();
        if(dealerSellProductDetails!=null){
            returnMap.put("pagenum",dealerSellProductDetails.size());
            returnMap.put("thispage",dealerSellProductDetailPage.getThispage());
            returnMap.put("totalpage",dealerSellProductDetailPage.getTotalpage());
            returnMap.put("pagedata",dealerSellProductDetails);
            return returnMap;
        }
        else {
            returnMap.put("error","页信息错误，或不存在信息");
            return returnMap;
        }
    }
}
