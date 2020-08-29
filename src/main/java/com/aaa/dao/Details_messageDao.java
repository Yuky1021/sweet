package com.aaa.dao;

import com.aaa.entity.Details_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Details_messageDao extends tk.mybatis.mapper.common.Mapper<Details_message> {

    @Select("select * from details_message where bmid=#{bmid}")
    List<Details_message> SelbyBmid(@Param("bmid") String bmid);



}
