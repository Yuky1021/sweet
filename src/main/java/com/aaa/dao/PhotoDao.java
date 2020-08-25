package com.aaa.dao;

import com.aaa.entity.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PhotoDao extends tk.mybatis.mapper.common.Mapper<Photo> {
    @Select("select ph.phid,ph.url,bg.bmname from photo ph left join basic_message bg on bg.bmid=ph.bmid")
    List<Map<String,Object>> listAll();
}
