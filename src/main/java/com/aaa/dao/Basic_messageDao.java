package com.aaa.dao;

import com.aaa.entity.Basic_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Basic_messageDao {

    //查询
    @Select("select bs.*,ds.soliloquy,ds.pic from basic_message bs left join details_message ds on bs.bmid=ds.bmid limit 4")
    public List<Map<String,Object>> findAll();

    //根据ID查询
    @Select("select bs.*,ds.soliloquy,ds.pic,ds.truename from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.bmid=#{bmid}")
    public List<Map<String,Object>> findAllById(@Param("bmid") Integer bmid);

}
