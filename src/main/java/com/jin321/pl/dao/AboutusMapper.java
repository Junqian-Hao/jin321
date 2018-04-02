package com.jin321.pl.dao;

import com.jin321.pl.model.Aboutus;
import com.jin321.pl.model.AboutusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AboutusMapper {
    int countByExample(AboutusExample example);

    int deleteByExample(AboutusExample example);

    int deleteByPrimaryKey(Integer auid);

    int insert(Aboutus record);

    int insertSelective(Aboutus record);

    List<Aboutus> selectByExample(AboutusExample example);

    Aboutus selectByPrimaryKey(Integer auid);

    int updateByExampleSelective(@Param("record") Aboutus record, @Param("example") AboutusExample example);

    int updateByExample(@Param("record") Aboutus record, @Param("example") AboutusExample example);

    int updateByPrimaryKeySelective(Aboutus record);

    int updateByPrimaryKey(Aboutus record);
}