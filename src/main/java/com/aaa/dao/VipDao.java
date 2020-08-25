package com.aaa.dao;

import com.aaa.entity.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface VipDao extends tk.mybatis.mapper.common.Mapper<Vip> {
    @Select("select v.vid,v.project,v.paytime,v.vtime,b.bmname from vip v left join basic_message b on v.bmid=b.bmid")
    List<Map<String,Object>> listAll();
}
