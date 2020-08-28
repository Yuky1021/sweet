package com.aaa.dao;

import com.aaa.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageDao extends tk.mybatis.mapper.common.Mapper<Message> {
    @Select("select me.meid,bm.bmname as bname,bg.bmname,me.context from message me left join basic_message bm on bm.bmid=me.one left join basic_message bg on bg.bmid=me.tow")
    List<Map<String,Object>> listAll();
}
