package com.jin321.pl.dao;

import com.jin321.pl.model.Paybackevent;
import com.jin321.pl.model.PaybackeventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaybackeventMapper {
    int countByExample(PaybackeventExample example);

    int deleteByExample(PaybackeventExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Paybackevent record);

    int insertSelective(Paybackevent record);

    List<Paybackevent> selectByExample(PaybackeventExample example);

    Paybackevent selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Paybackevent record, @Param("example") PaybackeventExample example);

    int updateByExample(@Param("record") Paybackevent record, @Param("example") PaybackeventExample example);

    int updateByPrimaryKeySelective(Paybackevent record);

    int updateByPrimaryKey(Paybackevent record);
}