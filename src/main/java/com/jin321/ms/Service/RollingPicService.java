package com.jin321.ms.Service;

import com.jin321.pl.model.Rollingpick;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

/**
 * Created by Tyranitarx on 2017/11/7.
 *
 * @Description :
 */
public interface RollingPicService {
    /**
     * 插入轮播图
     * @param rollingpick
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int insertRollingPic(Rollingpick rollingpick);

    /**
     * 删除全部轮播图
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int deleteAllRollingPic();

    /**
     * 删除轮播图
     * @param rpid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int deleteRollingPic(int rpid);
}
