package com.jin321.pl.dao;

import com.jin321.pl.model.Useraddress;
import com.jin321.pl.model.UseraddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UseraddressMapper {
    int countByExample(UseraddressExample example);

    int deleteByExample(UseraddressExample example);

    int deleteByPrimaryKey(Integer uaid);

    int insert(Useraddress record);

    int insertSelective(Useraddress record);

    List<Useraddress> selectByExample(UseraddressExample example);

    Useraddress selectByPrimaryKey(Integer uaid);

    int updateByExampleSelective(@Param("record") Useraddress record, @Param("example") UseraddressExample example);

    int updateByExample(@Param("record") Useraddress record, @Param("example") UseraddressExample example);

    int updateByPrimaryKeySelective(Useraddress record);

    int updateByPrimaryKey(Useraddress record);
}