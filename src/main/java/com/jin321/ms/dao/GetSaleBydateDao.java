package com.jin321.ms.dao;

import com.jin321.pl.model.Dealerbuyform;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetSaleBydateDao {
    public List<Dealerbuyform> getSaleByMonth(String month);
}
