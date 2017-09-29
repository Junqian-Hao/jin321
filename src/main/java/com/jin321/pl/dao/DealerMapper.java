package com.jin321.pl.dao;

import com.jin321.pl.model.Dealer;
import com.jin321.pl.model.DealerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealerMapper {
    int countByExample(DealerExample example);

    int deleteByExample(DealerExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Dealer record);

    int insertSelective(Dealer record);

    List<Dealer> selectByExample(DealerExample example);

    Dealer selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Dealer record, @Param("example") DealerExample example);

    int updateByExample(@Param("record") Dealer record, @Param("example") DealerExample example);

    int updateByPrimaryKeySelective(Dealer record);

    int updateByPrimaryKey(Dealer record);
}