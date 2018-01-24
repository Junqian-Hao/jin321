package com.jin321.pl.dao;

import com.jin321.pl.model.Expressage;
import com.jin321.pl.model.ExpressageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressageMapper {
    int countByExample(ExpressageExample example);

    int deleteByExample(ExpressageExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Expressage record);

    int insertSelective(Expressage record);

    List<Expressage> selectByExample(ExpressageExample example);

    Expressage selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Expressage record, @Param("example") ExpressageExample example);

    int updateByExample(@Param("record") Expressage record, @Param("example") ExpressageExample example);

    int updateByPrimaryKeySelective(Expressage record);

    int updateByPrimaryKey(Expressage record);
}