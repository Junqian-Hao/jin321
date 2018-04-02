package com.jin321.pl.dao;

import com.jin321.pl.model.Dealerbuyform;
import com.jin321.pl.model.DealerbuyformExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealerbuyformMapper {
    int countByExample(DealerbuyformExample example);

    int deleteByExample(DealerbuyformExample example);

    int deleteByPrimaryKey(Long dbfid);

    int insert(Dealerbuyform record);

    int insertSelective(Dealerbuyform record);

    List<Dealerbuyform> selectByExample(DealerbuyformExample example);

    Dealerbuyform selectByPrimaryKey(Long dbfid);

    int updateByExampleSelective(@Param("record") Dealerbuyform record, @Param("example") DealerbuyformExample example);

    int updateByExample(@Param("record") Dealerbuyform record, @Param("example") DealerbuyformExample example);

    int updateByPrimaryKeySelective(Dealerbuyform record);

    int updateByPrimaryKey(Dealerbuyform record);
}