package com.aaa.dao;

import com.aaa.entity.Media;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MediaDao {

    @Select("select * from media")
    public List<Media> listAll();
}
