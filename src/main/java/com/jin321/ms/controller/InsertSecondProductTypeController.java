package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductTypeService;
import com.jin321.pl.model.Producttype;
import com.jin321.pl.utils.UrlUtil;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Tyranitarx on 2017/11/5.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class InsertSecondProductTypeController {
    private static final Log log = LogFactory.getLog(InsertSecondProductTypeController.class);
    @Autowired
    private ProductTypeService productTypeService;
    private Producttype producttype;
    private int sign;
    private Map<String,String> returnMap;
    private UUID uuid;
    private String uuids;
    @ResponseBody
    @RequestMapping("/insertSecondProductType")
    public Map<String,String> insertFirstProductType(
            @RequestParam("file")CommonsMultipartFile file,
            @RequestParam("typename") String typename,
            @RequestParam("highertid")String highertid,
            HttpServletRequest request) {
        log.debug("typename"+typename);
        log.debug("文件为:"+file);
        log.debug("上一级id"+highertid);
        returnMap=new HashMap<String, String>();
        producttype=new Producttype();
        try {
            if (!file.isEmpty()) {
                uuid = UUID.randomUUID();
                uuids = uuid.toString();
                uuids = uuids.replaceAll("-", "");
                //使用StreamsAPI方式拷贝文件
                Streams.copy(file.getInputStream(), new FileOutputStream(UrlUtil.getRealPath(request) + "productsecondtype/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."))), true);
                //log.info(UrlUtil.getRealPath(request)+"productdetail\\"+uuids+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf(".")));
                producttype.setTypename(typename);
                producttype.setHighertid(Integer.parseInt(highertid));
                producttype.setTypeclass(2);
                producttype.setPicurl( "productsecondtype/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")));
                sign=productTypeService.insertSecondType(producttype);
            }
        } catch (IOException e) {
            //log.info("详情图片上传失败");
            e.printStackTrace();
            returnMap.put("code", "0");
            returnMap.put("msg", "详情图片上传失败");
            return returnMap;
        }
        if(sign==-1){
            returnMap.put("code", "-1");
            returnMap.put("msg", "品牌已存在");
            return returnMap;
        }
        else if(sign==0){
            returnMap.put("code", "0");
            returnMap.put("msg", "添加失败");
            return returnMap;
        }
        else{
            returnMap.put("code", "1");
            returnMap.put("msg", "添加成功");
            return returnMap;
        }
    }
}