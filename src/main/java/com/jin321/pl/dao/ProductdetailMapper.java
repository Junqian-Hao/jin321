package com.jin321.pl.dao;

import com.jin321.pl.model.Productdetail;
import com.jin321.pl.model.ProductdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductdetailMapper {
    int countByExample(ProductdetailExample example);

    int deleteByExample(ProductdetailExample example);

    int deleteByPrimaryKey(Integer pdid);

    int insert(Productdetail record);

    int insertSelective(Productdetail record);

    List<Productdetail> selectByExample(ProductdetailExample example);

    Productdetail selectByPrimaryKey(Integer pdid);

    int updateByExampleSelective(@Param("record") Productdetail record, @Param("example") ProductdetailExample example);

    int updateByExample(@Param("record") Productdetail record, @Param("example") ProductdetailExample example);

    int updateByPrimaryKeySelective(Productdetail record);

    int updateByPrimaryKey(Productdetail record);
}