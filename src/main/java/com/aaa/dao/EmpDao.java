package com.aaa.dao;

import com.aaa.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpDao extends tk.mybatis.mapper.common.Mapper<Emp> {

    @Select("select * from emp where state=1")
    List<Emp> findByState();

    @Select("select * from emp where ename=#{ename}")
    List<Emp> findByName(String ename);


    @Update("update emp set ename=#{ename},epwd=#{epwd},truename=#{truename},sex=#{sex},phone=#{phone},address=#{address},state=0 where emid=#{emid}")
    int update(Emp emp);

    @Select("select count(emid) from emp")
    public int totalCount();

    @Select("select  * from emp where ename=#{ename} and epwd=#{epwd} and state=0")
    List<Map<String,Object>> login(@Param("ename") String ename,@Param("epwd") String epwd);
}
