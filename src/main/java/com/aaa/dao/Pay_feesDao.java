package com.aaa.dao;

import com.aaa.entity.Pay_fees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Pay_feesDao extends tk.mybatis.mapper.common.Mapper<Pay_fees> {
    //查询
    @Select("select * from pay_fees")
    public List<Pay_fees> listAll();


    @Select("select p.pfid,p.peoject,p.money,p.paytime,p.ptime,b.bmname from pay_fees p left join basic_message b on p.bmid=b.bmid")
    List<Map<String,Object>> findAll();
}
