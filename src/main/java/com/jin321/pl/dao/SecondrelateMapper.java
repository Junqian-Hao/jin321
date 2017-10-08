package com.jin321.pl.dao;

import com.jin321.pl.model.Secondrelate;
import com.jin321.pl.model.SecondrelateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondrelateMapper {
    int countByExample(SecondrelateExample example);

    int deleteByExample(SecondrelateExample example);

    int deleteByPrimaryKey(Integer r2id);

    int insert(Secondrelate record);

    int insertSelective(Secondrelate record);

    List<Secondrelate> selectByExample(SecondrelateExample example);

    Secondrelate selectByPrimaryKey(Integer r2id);

    int updateByExampleSelective(@Param("record") Secondrelate record, @Param("example") SecondrelateExample example);

    int updateByExample(@Param("record") Secondrelate record, @Param("example") SecondrelateExample example);

    int updateByPrimaryKeySelective(Secondrelate record);

    int updateByPrimaryKey(Secondrelate record);
}