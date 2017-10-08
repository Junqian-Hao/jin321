package com.jin321.pl.dao;

import com.jin321.pl.model.Orderform;
import com.jin321.pl.model.OrderformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderformMapper {
    int countByExample(OrderformExample example);

    int deleteByExample(OrderformExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    List<Orderform> selectByExampleWithBLOBs(OrderformExample example);

    List<Orderform> selectByExample(OrderformExample example);

    Orderform selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Orderform record, @Param("example") OrderformExample example);

    int updateByExampleWithBLOBs(@Param("record") Orderform record, @Param("example") OrderformExample example);

    int updateByExample(@Param("record") Orderform record, @Param("example") OrderformExample example);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKeyWithBLOBs(Orderform record);

    int updateByPrimaryKey(Orderform record);
}