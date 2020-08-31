package com.aaa.dao;

import com.aaa.entity.Profession_type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Profession_typeDao extends tk.mybatis.mapper.common.Mapper<Profession_type> {

    //count
    @Select("select count(ptid) from profession_type")
    public int totalCount();
}
