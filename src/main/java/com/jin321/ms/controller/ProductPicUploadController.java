package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductPicService;
import com.jin321.pl.model.Productpics;
import org.apache.commons.fileupload.util.Streams;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Tyranitarx on 2017/10/9.
 *
 * @Description : 商品相关图片上传
 */
@Controller
@RequestMapping("/ms")
public class ProductPicUploadController {
    private static final Log log = LogFactory.getLog(ProductPicUploadController.class);
    @Autowired
    private ProductPicService productPicService;
    private Map<String,String> returnmap;
    private Integer pid;
    private Productpics productpics;
    private UUID uuid;
    private String uuids;
    @ResponseBody
    @RequestMapping(value = "/productpicupload",method = RequestMethod.POST)
    public Map<String, String> productPicUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile[] file){
        uuid=UUID.randomUUID();
        uuids=uuid.toString();
        uuids=uuids.replaceAll("-","");
        returnmap=new HashMap<String,String>();
        //分别获取的是变量名file---文件类型---文件名
        pid=(Integer) request.getSession().getAttribute("pid");
        try {
            for (int i=0;i<file.length;i++) {
                if (!file[i].isEmpty()) {
                    //使用StreamsAPI方式拷贝文件
                    Streams.copy(file[i].getInputStream(), new FileOutputStream("E:\\程序\\jin321\\target\\jin321\\productpics\\"+uuids+"."+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf("."))), true);
                    productpics=new Productpics();
                    productpics.setPid(pid);
                    productpics.setPpicurl("\\productpics\\"+uuids+"."+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf(".")));
                    productpics.setIsDeleted(false);
                    productPicService.productPicUpdate(productpics);
                }
            }
        } catch (IOException e) {
            log.info("相关图片上传失败");
            e.printStackTrace();
            returnmap.put("code","0");
            returnmap.put("msg","相关图片上传失败");
            return returnmap;
        }
        returnmap.put("code","1");
        returnmap.put("msg","相关图片上传成功");
        return returnmap;
    }
}
