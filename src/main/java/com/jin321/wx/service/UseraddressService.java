package com.jin321.wx.service;

import com.jin321.pl.model.Useraddress;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/10/10 18:29
 * @Description :用户收货地址
 */
public interface UseraddressService {
    /**
     * 添加用户收货地址
     * @param useraddress
     * @return
     * @throws Exception
     */
    boolean insertUseraddress(Useraddress useraddress) throws Exception;

    /**
     * 通过收货地址id删除用户收货地址
     * @param uaid
     * @return
     */
    boolean deleteUseraddressByid(int uaid)throws Exception;

    /**
     * 通过收货地址id更新收货地址
     * @param useraddress
     * @return
     */
    boolean updateUseraddressByid(Useraddress useraddress)throws Exception;

    /**
     * 通过uid查询用户的全部收货地址
     * @param uid
     * @return
     */
    List<Useraddress> selectUseraddressByuid(String uid)throws Exception;
}
