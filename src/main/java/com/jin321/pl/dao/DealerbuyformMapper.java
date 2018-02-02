package com.jin321.pl.dao;

import com.jin321.pl.model.Dealerbuyform;
import com.jin321.pl.model.DealerbuyformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealerbuyformMapper {
    int countByExample(DealerbuyformExample example);

    int deleteByExample(DealerbuyformExample example);

    int deleteByPrimaryKey(Integer dbfid);

    int insert(Dealerbuyform record);

    int insertSelective(Dealerbuyform record);

    List<Dealerbuyform> selectByExample(DealerbuyformExample example);

    Dealerbuyform selectByPrimaryKey(Integer dbfid);

    int updateByExampleSelective(@Param("record") Dealerbuyform record, @Param("example") DealerbuyformExample example);

    int updateByExample(@Param("record") Dealerbuyform record, @Param("example") DealerbuyformExample example);

    int updateByPrimaryKeySelective(Dealerbuyform record);

    int updateByPrimaryKey(Dealerbuyform record);
}