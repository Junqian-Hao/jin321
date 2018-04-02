package com.jin321.pl.dao;

import com.jin321.pl.model.Paybackevent;
import com.jin321.pl.model.PaybackeventExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaybackeventMapper {
    int countByExample(PaybackeventExample example);

    int deleteByExample(PaybackeventExample example);

    int deleteByPrimaryKey(Long eid);

    int insert(Paybackevent record);

    int insertSelective(Paybackevent record);

    List<Paybackevent> selectByExample(PaybackeventExample example);

    Paybackevent selectByPrimaryKey(Long eid);

    int updateByExampleSelective(@Param("record") Paybackevent record, @Param("example") PaybackeventExample example);

    int updateByExample(@Param("record") Paybackevent record, @Param("example") PaybackeventExample example);

    int updateByPrimaryKeySelective(Paybackevent record);

    int updateByPrimaryKey(Paybackevent record);
}