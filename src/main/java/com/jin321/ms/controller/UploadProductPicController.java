package com.jin321.ms.controller;

import com.jin321.ms.Service.ProductPicService;
import com.jin321.pl.model.Productpics;
import com.jin321.pl.utils.UrlUtil;
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
 * 样例JSON
 *
 */
@Controller
@RequestMapping("/ms")
public class UploadProductPicController {
    private static final Log log = LogFactory.getLog(UploadProductPicController.class);
    @Autowired
    private ProductPicService productPicService;
    private Map<String,String> returnmap;
    private Productpics productpics;
    private UUID uuid;
    private String uuids;
    @ResponseBody
    @RequestMapping(value = "/productPicUpload",method = RequestMethod.POST)
    public Map<String, String> productPicUpload(HttpServletRequest request,
                                                @RequestParam("file") CommonsMultipartFile[] file
                                                ,@RequestParam("header")String header,
                                                @RequestParam("pid")String pid){
        log.info("上传图片或缩略图");
        returnmap=new HashMap<String,String>();
        //分别获取的是变量名file---文件类型---文件名
        productPicService.productNoHeadPicDelete(Integer.parseInt(pid),UrlUtil.getRealPath(request));
        try {
            for (int i=0;i<file.length;i++) {
                if (!file[i].isEmpty()) {
                    uuid=UUID.randomUUID();
                    uuids=uuid.toString();
                    uuids=uuids.replaceAll("-","");
                    //使用StreamsAPI方式拷贝文件
                    Streams.copy(file[i].getInputStream(), new FileOutputStream(UrlUtil.getRealPath(request)+"productpics/"+uuids+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf("."))), true);
                    productpics=new Productpics();
                    productpics.setPid(Integer.parseInt(pid));
                    productpics.setPpicurl("productpics/"+uuids+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf(".")));
                    productpics.setIsDeleted(false);
                    if(Integer.parseInt(header)==0)
                        productPicService.productPicUpdate(productpics);
                    else
                        productPicService.productHeadPicService(productpics);

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
