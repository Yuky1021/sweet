package com.aaa.dao;

import com.aaa.entity.comment_paste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface comment_pasteDao  extends tk.mybatis.mapper.common.Mapper<comment_paste> {


    @Select("select cp.cpid,cp.title,cp.context,cp.commention,sp.title,bm.bmname from comment_paste cp left join send_paste sp on cp.spid=sp.spid left join basic_message bm on bm.bmid=cp.bmid")
    List<Map<String,Object>>  findAll();
}
