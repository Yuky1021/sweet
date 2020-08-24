package com.aaa.dao;

import com.aaa.entity.Pay_fees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Pay_feesDao {
    //查询
    @Select("select * from pay_fees")
    public List<Pay_fees> listAll();
}
