package com.jin321.pl.dao;

import com.jin321.pl.model.Rollingpick;
import com.jin321.pl.model.RollingpickExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollingpickMapper {
    int countByExample(RollingpickExample example);

    int deleteByExample(RollingpickExample example);

    int deleteByPrimaryKey(Integer rpid);

    int insert(Rollingpick record);

    int insertSelective(Rollingpick record);

    List<Rollingpick> selectByExample(RollingpickExample example);

    Rollingpick selectByPrimaryKey(Integer rpid);

    int updateByExampleSelective(@Param("record") Rollingpick record, @Param("example") RollingpickExample example);

    int updateByExample(@Param("record") Rollingpick record, @Param("example") RollingpickExample example);

    int updateByPrimaryKeySelective(Rollingpick record);

    int updateByPrimaryKey(Rollingpick record);
}