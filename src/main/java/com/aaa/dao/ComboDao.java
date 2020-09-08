package com.aaa.dao;

import com.aaa.entity.Combo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComboDao  extends tk.mybatis.mapper.common.Mapper<Combo> {

    //前台查询套餐
    @Select("select * from combo order by coid  desc")
    List<Combo> showtVIP();


}
