package com.jin321.pl.dao;

import com.jin321.pl.model.Chart;
import com.jin321.pl.model.ChartExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChartMapper {
    int countByExample(ChartExample example);

    int deleteByExample(ChartExample example);

    int deleteByPrimaryKey(Integer cartid);

    int insert(Chart record);

    int insertSelective(Chart record);

    List<Chart> selectByExample(ChartExample example);

    Chart selectByPrimaryKey(Integer cartid);

    int updateByExampleSelective(@Param("record") Chart record, @Param("example") ChartExample example);

    int updateByExample(@Param("record") Chart record, @Param("example") ChartExample example);

    int updateByPrimaryKeySelective(Chart record);

    int updateByPrimaryKey(Chart record);
}