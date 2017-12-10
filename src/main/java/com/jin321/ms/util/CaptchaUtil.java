package com.jin321.ms.util;

import com.jin321.ms.controller.CaptchaController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Tyranitarx on 2017/10/5.
 *
 * @Description : 验证码生成工具
 */

public class CaptchaUtil{
    private static final Log log = LogFactory.getLog(CaptchaUtil.class);
    private static char[] chs = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".toCharArray();
        private static final int NUMBER_OF_CHS = 4;
        private static final int IMG_WIDTH = 65;
        private static final int IMG_HEIGHT = 25;
        public static BufferedImage generateCaptcha(HttpServletRequest request){
            Random r = new Random();
            BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);    // 实例化BufferedImage
            Graphics g = image.getGraphics();
            Color c = new Color(200, 200, 255);                                             // 验证码图片的背景颜色
            g.setColor(c);
            g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);                                        // 图片的边框
            StringBuffer sb = new StringBuffer();                                           // 用于保存验证码字符串
            int index;                                                                      // 数组的下标
            for (int i = 0; i < NUMBER_OF_CHS; i++) {
                index = r.nextInt(chs.length);                                              // 随机一个下标
                g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));       // 随机一个颜色
                g.drawString(chs[index] + "", 15 * i + 3, 18);                              // 画出字符
                sb.append(chs[index]);                                                      // 验证码字符串
            }
            log.info("生成的验证码为:"+sb.toString());
            request.getSession().setAttribute("verifycode",sb.toString());
            return image;
    }
}