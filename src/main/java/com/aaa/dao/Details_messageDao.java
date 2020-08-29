package com.aaa.dao;

import com.aaa.entity.Details_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Details_messageDao extends tk.mybatis.mapper.common.Mapper<Details_message> {

    @Select("select count(tid) from teacher")
    public int totalCount();

    @Select("select d.dmid,d.native,d.truename,d.Idcard,d.pic,d.constellation,d.nation,d.children,d.education,d.soliloquy,d.monthly,b.bmname from details_message d left join basic_message b on d.bmid=b.bmid")
    List<Map<String,Object>> findAll();
                                                                                                                                                                                         
}
