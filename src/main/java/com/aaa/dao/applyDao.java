package com.aaa.dao;

import com.aaa.entity.apply;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


@org.apache.ibatis.annotations.Mapper
public interface applyDao extends Mapper<apply> {

    @Select("select ap.apid,ap.name,ap.part,ap.phone,ap.wechat,ac.title,bm.bmname from apply ap left join activity ac on ac.acid=ap.acid left join basic_message bm on bm.bmid=ap.bmid")
    List<Map<String,Object>> findAll();


}
