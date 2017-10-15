package com.jin321.pl.dao;

import com.jin321.pl.model.Timeproduct;
import com.jin321.pl.model.TimeproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeproductMapper {
    int countByExample(TimeproductExample example);

    int deleteByExample(TimeproductExample example);

    int deleteByPrimaryKey(Integer tpid);

    int insert(Timeproduct record);

    int insertSelective(Timeproduct record);

    List<Timeproduct> selectByExample(TimeproductExample example);

    Timeproduct selectByPrimaryKey(Integer tpid);

    int updateByExampleSelective(@Param("record") Timeproduct record, @Param("example") TimeproductExample example);

    int updateByExample(@Param("record") Timeproduct record, @Param("example") TimeproductExample example);

    int updateByPrimaryKeySelective(Timeproduct record);

    int updateByPrimaryKey(Timeproduct record);
}