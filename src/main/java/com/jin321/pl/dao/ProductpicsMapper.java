package com.jin321.pl.dao;

import com.jin321.pl.model.Productpics;
import com.jin321.pl.model.ProductpicsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductpicsMapper {
    int countByExample(ProductpicsExample example);

    int deleteByExample(ProductpicsExample example);

    int deleteByPrimaryKey(Integer ppid);

    int insert(Productpics record);

    int insertSelective(Productpics record);

    List<Productpics> selectByExample(ProductpicsExample example);

    Productpics selectByPrimaryKey(Integer ppid);

    int updateByExampleSelective(@Param("record") Productpics record, @Param("example") ProductpicsExample example);

    int updateByExample(@Param("record") Productpics record, @Param("example") ProductpicsExample example);

    int updateByPrimaryKeySelective(Productpics record);

    int updateByPrimaryKey(Productpics record);
}