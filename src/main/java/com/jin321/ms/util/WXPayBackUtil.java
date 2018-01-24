package com.jin321.ms.util;

import com.jin321.pl.utils.PayCommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom2.JDOMException;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.math.BigDecimal;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Tyranitarx on 2018/1/24.
 *
 * @Description :
 */
public class WXPayBackUtil {
    private static final Log log = LogFactory.getLog(WXPayBackUtil.class);
    //appid
    public static String APPID = "wxd390b42487afbe16";
    //商户号
    public static String MCH_ID = "1490493672";
    public static Map WXPayBack(Long oid,Long eid,BigDecimal total,BigDecimal back) throws JDOMException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyManagementException {
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();
        parameterMap.put("appid",WXPayBackUtil.APPID);
        parameterMap.put("mch_id", PayCommonUtil.MCH_ID);
        parameterMap.put("nonce_str", PayCommonUtil.getRandomString(32));
        parameterMap.put("out_trade_no",oid.toString());
        parameterMap.put("out_refund_no",eid.toString());
        BigDecimal totalmoney = total.multiply(new BigDecimal(100));
        BigDecimal refundmoney=back.multiply(new BigDecimal(100));
        java.text.DecimalFormat df = new java.text.DecimalFormat("0");
        parameterMap.put("total_fee",df.format(totalmoney));
        parameterMap.put("refund_fee",df.format(refundmoney));
        String sign = PayCommonUtil.createSign(parameterMap);
        parameterMap.put("sign",sign);
        String requestXml =PayCommonUtil.getRequestXml(parameterMap);
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        StringBuffer sb=new StringBuffer();
        FileInputStream instream = new FileInputStream(new File("/root/apache-tomcat-8.5.23/conf/apiclient_cert.p12"));//放退款证书的路径
        try {
            keyStore.load(instream, WXPayBackUtil.MCH_ID.toCharArray());
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore,WXPayBackUtil.MCH_ID.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {

            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/secapi/pay/refund");//退款接口
            StringEntity  reqEntity;
            reqEntity = new StringEntity(requestXml);
            // 设置类型
            reqEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        sb.append(text);
                    }
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return PayCommonUtil.doXMLParse(sb.toString());
    }
}
