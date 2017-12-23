package com.jin321.wx.utils;

import com.jin321.pl.utils.PayCommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.JDOMException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author hao
 * @Date 2017/10/1 17:43
 * @Description :
 */
public class WXUtil {
    private static final Log log = LogFactory.getLog(WXUtil.class);
    //appid
    public static String APPID = "wxd390b42487afbe16";
    //secret
    public static String SECRET = "93e4f9508f806ea59999f1608b688f6f";
    public static String MCH_ID = "1490493672";
    public static String API_KEY = "wcHennuqkIR6Gg0WsYV5kPPpAy0Y8pZr";
    public static String BASEPATH = "https://test-1252104972.file.myqcloud.com/jin321/";

    /**
     * 微信统一下单API
     * @param sn          商户订单号
     * @param totalAmount 总金额 单位元精确到分
     * @param body        商品描述
     * @param openid      用户openid
     * @param request
     * @return
     */
    public static Map<String, String> weixinPrePay(String sn, BigDecimal totalAmount, String body, String openid, HttpServletRequest request) throws JDOMException, IOException {
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();
        parameterMap.put("appid", PayCommonUtil.APPID);
        parameterMap.put("mch_id", PayCommonUtil.MCH_ID);
        parameterMap.put("nonce_str", PayCommonUtil.getRandomString(32));
        parameterMap.put("body", body);
        parameterMap.put("out_trade_no", sn);
        parameterMap.put("fee_type", "CNY");
        BigDecimal total = totalAmount.multiply(new BigDecimal(100));
        java.text.DecimalFormat df = new java.text.DecimalFormat("0");
        parameterMap.put("total_fee", df.format(total));
        parameterMap.put("spbill_create_ip", request.getRemoteAddr());
        parameterMap.put("notify_url", "http://www.jin321.cn/jin321/ms/recievePayMessage.do");
        parameterMap.put("trade_type", "JSAPI");
        parameterMap.put("openid", openid);
        String sign = PayCommonUtil.createSign(parameterMap);
        log.info("统一下单签名内容："+sign);
        parameterMap.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(parameterMap);
        System.out.println(requestXML);
        String result = PayCommonUtil.httpsRequest(
                "https://api.mch.weixin.qq.com/pay/unifiedorder", "POST", requestXML);
        log.info("统一下单api微信返回-》"+result);
        Map<String, String> map = null;

        map = PayCommonUtil.doXMLParse(result);

        return map;
    }
}
