package com.jin321.pl.dao;

import com.jin321.pl.model.Orderformproduct;
import com.jin321.pl.model.OrderformproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderformproductMapper {
    int countByExample(OrderformproductExample example);

    int deleteByExample(OrderformproductExample example);

    int deleteByPrimaryKey(Integer ofpid);

    int insert(Orderformproduct record);

    int insertSelective(Orderformproduct record);

    List<Orderformproduct> selectByExample(OrderformproductExample example);

    Orderformproduct selectByPrimaryKey(Integer ofpid);

    int updateByExampleSelective(@Param("record") Orderformproduct record, @Param("example") OrderformproductExample example);

    int updateByExample(@Param("record") Orderformproduct record, @Param("example") OrderformproductExample example);

    int updateByPrimaryKeySelective(Orderformproduct record);

    int updateByPrimaryKey(Orderformproduct record);
}