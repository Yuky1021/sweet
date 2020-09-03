package com.aaa.dao;


import com.aaa.entity.admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper

public interface adminsDao extends Mapper<admins> {

    @Select("select  * from admins where adname=#{adname} and pwd=#{pwd} and state=0")
    List<Map<String,Object>> login(@Param("adname") String adname, @Param("pwd") String pwd);

    @Select("select * from admins where adname='admin'")
    List<admins> findByName(String adname);

    @Update("update admins set pwd=#{pwd},adname='admin',state=0 where adid=1")
    int update(admins admin);
}
