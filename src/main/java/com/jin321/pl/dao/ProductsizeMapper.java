package com.jin321.pl.dao;

import com.jin321.pl.model.Productsize;
import com.jin321.pl.model.ProductsizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsizeMapper {
    int countByExample(ProductsizeExample example);

    int deleteByExample(ProductsizeExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Productsize record);

    int insertSelective(Productsize record);

    List<Productsize> selectByExample(ProductsizeExample example);

    Productsize selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Productsize record, @Param("example") ProductsizeExample example);

    int updateByExample(@Param("record") Productsize record, @Param("example") ProductsizeExample example);

    int updateByPrimaryKeySelective(Productsize record);

    int updateByPrimaryKey(Productsize record);
}