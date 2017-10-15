package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductDetailService;
import com.jin321.pl.model.Productdetail;
import org.apache.commons.fileupload.util.Streams;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 详细信息图片上传接口
 */
@Controller
@RequestMapping("/ms")
public class ProductDetailUploadController{
    private static final Log log = LogFactory.getLog(ProductDetailUploadController.class);
    @Autowired
    private ProductDetailService productDetailService;
    private UUID uuid;
    private String uuids;
    private Map<String,String> returnmap;
    private Productdetail productdetail;
    private Integer pid;
    @ResponseBody
    @RequestMapping(value = "/productdetailupload",method = RequestMethod.POST)
    public Map<String, String> productDetailUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile[] file){
        returnmap=new HashMap<String,String>();
        //分别获取的是变量名file---文件类型---文件名
        pid=(Integer) request.getSession().getAttribute("pid");
        try {
            for (int i=0;i<file.length;i++) {
                if (!file[i].isEmpty()) {
                    uuid=UUID.randomUUID();
                    uuids=uuid.toString();
                    uuids=uuids.replaceAll("-","");
                    //使用StreamsAPI方式拷贝文件
                    Streams.copy(file[i].getInputStream(), new FileOutputStream("E:\\程序\\jin321\\target\\jin321\\productdetail\\" +uuids+"."+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf("."))), true);
                    productdetail=new Productdetail();
                    productdetail.setPid(pid);
                    productdetail.setPicurl("\\productdetail\\"+uuids+"."+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf(".")));
                    productdetail.setIsDeleted(false);
                    productDetailService.productDetailUpdate(productdetail);
                }
            }
        } catch (IOException e) {
            log.info("详情图片上传失败");
            e.printStackTrace();
            returnmap.put("code","0");
            returnmap.put("msg","详情图片上传失败");
            return returnmap;
        }
        returnmap.put("code","1");
        returnmap.put("msg","详情图片上传成功");
        return returnmap;
    }
}
