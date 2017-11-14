package com.jin321.ms.controller;

import com.jin321.ms.Service.RollingPicService;
import com.jin321.pl.model.Rollingpick;
import com.jin321.pl.utils.UrlUtil;
import org.apache.commons.fileupload.util.Streams;
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
 * Created by Tyranitarx on 2017/11/7.
 *
 * @Description :
 */
@Controller
@RequestMapping("/ms")
public class UploadRollingPicController {
    @Autowired
    private RollingPicService rollingPicService;
    private Rollingpick rollingpick;
    private Map<String,String> returnMap;
    private int sign;
    private UUID uuid;
    private String uuids;
    @ResponseBody
    @RequestMapping("/insertRollingPic")
    public Map<String,String> insertRollingPic(@RequestParam("file")CommonsMultipartFile file,
                                               @RequestParam("pid") int pid[],
                                               HttpServletRequest request){
        returnMap=new HashMap<String, String>();
        rollingPicService.deleteAllRollingPic();
        int i=0;
        try {
            if (!file.isEmpty()) {
                uuid = UUID.randomUUID();
                uuids = uuid.toString();
                uuids = uuids.replaceAll("-", "");
                //使用StreamsAPI方式拷贝文件
                Streams.copy(file.getInputStream(), new FileOutputStream(UrlUtil.getRealPath(request) + "rollingpick/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."))), true);
                //log.info(UrlUtil.getRealPath(request)+"productdetail\\"+uuids+file[i].getOriginalFilename().substring(file[i].getOriginalFilename().indexOf(".")));
                rollingpick=new Rollingpick();
                rollingpick.setIsDeleted(false);
                rollingpick.setPid(pid[0]);
                i++;
                rollingpick.setRpicurl("rollingpick/" + uuids + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")));
                sign=rollingPicService.insertRollingPic(rollingpick);
            }
        } catch (IOException e) {
            //log.info("详情图片上传失败");
            e.printStackTrace();
            returnMap.put("code", "0");
            returnMap.put("msg", "轮播图上传失败");
            return returnMap;
        }
        if(sign==0){
            returnMap.put("code", "0");
            returnMap.put("msg", "轮播图上传失败");
            return returnMap;
        }
        else {
            returnMap.put("code", "1");
            returnMap.put("msg", "轮播图上传成功");
            return returnMap;
        }

    }

}
