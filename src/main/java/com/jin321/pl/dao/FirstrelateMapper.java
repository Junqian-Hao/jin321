package com.jin321.pl.dao;

import com.jin321.pl.model.Firstrelate;
import com.jin321.pl.model.FirstrelateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstrelateMapper {
    int countByExample(FirstrelateExample example);

    int deleteByExample(FirstrelateExample example);

    int deleteByPrimaryKey(Integer r1id);

    int insert(Firstrelate record);

    int insertSelective(Firstrelate record);

    List<Firstrelate> selectByExample(FirstrelateExample example);

    Firstrelate selectByPrimaryKey(Integer r1id);

    int updateByExampleSelective(@Param("record") Firstrelate record, @Param("example") FirstrelateExample example);

    int updateByExample(@Param("record") Firstrelate record, @Param("example") FirstrelateExample example);

    int updateByPrimaryKeySelective(Firstrelate record);

    int updateByPrimaryKey(Firstrelate record);
}