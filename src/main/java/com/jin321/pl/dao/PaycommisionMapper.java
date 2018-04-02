package com.jin321.pl.dao;

import com.jin321.pl.model.Paycommision;
import com.jin321.pl.model.PaycommisionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaycommisionMapper {
    int countByExample(PaycommisionExample example);

    int deleteByExample(PaycommisionExample example);

    int deleteByPrimaryKey(Integer pcid);

    int insert(Paycommision record);

    int insertSelective(Paycommision record);

    List<Paycommision> selectByExample(PaycommisionExample example);

    Paycommision selectByPrimaryKey(Integer pcid);

    int updateByExampleSelective(@Param("record") Paycommision record, @Param("example") PaycommisionExample example);

    int updateByExample(@Param("record") Paycommision record, @Param("example") PaycommisionExample example);

    int updateByPrimaryKeySelective(Paycommision record);

    int updateByPrimaryKey(Paycommision record);
}