package com.jin321.pl.dao;

import com.jin321.pl.model.Billtable;
import com.jin321.pl.model.BilltableExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BilltableMapper {
    int countByExample(BilltableExample example);

    int deleteByExample(BilltableExample example);

    int deleteByPrimaryKey(Integer btid);

    int insert(Billtable record);

    int insertSelective(Billtable record);

    List<Billtable> selectByExample(BilltableExample example);

    Billtable selectByPrimaryKey(Integer btid);

    int updateByExampleSelective(@Param("record") Billtable record, @Param("example") BilltableExample example);

    int updateByExample(@Param("record") Billtable record, @Param("example") BilltableExample example);

    int updateByPrimaryKeySelective(Billtable record);

    int updateByPrimaryKey(Billtable record);
}