package com.aaa.dao;

import com.aaa.entity.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttentionDao extends tk.mybatis.mapper.common.Mapper<Attention> {
    @Select("select att.attid,bm.bmname,bg.bmname from attention att left join basic_message bm on bm.bmid=att.baid left join basic_message bg on bg.bmid=att.aid")
    List<Map<String,Object>> listAll();
}
