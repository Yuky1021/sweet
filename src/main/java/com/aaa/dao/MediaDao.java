package com.aaa.dao;

import com.aaa.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MediaDao extends tk.mybatis.mapper.common.Mapper<Media> {

    @Select("select * from media")
    public List<Media> listAll();





    @Select("select * from media")
    List<Map<String,Object>> findAll();
}
