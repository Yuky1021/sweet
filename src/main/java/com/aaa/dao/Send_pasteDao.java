package com.aaa.dao;

import com.aaa.entity.Send_paste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Send_pasteDao extends tk.mybatis.mapper.common.Mapper<Send_paste> {
    @Select("select sp.spid,sp.title,sp.context,sp.sendtime,bg.bmname from send_paste sp left join basic_message bg on bg.bmid=sp.bmid")
    List<Map<String,Object>> listAll();
}
