package com.aaa.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ForeignKeyAddDao {
    //详细信息
    @Insert("insert into details_message(bmid) values(#{bmid})")
    int IFKdetails_message(@Param("bmid") String bmid);
    //工作生活
    @Insert("insert into life_message(bmid) values(#{bmid})")
    int IFKlife_message(@Param("bmid") String bmid);
    //择偶标准
    @Insert("insert into choose_mate(bmid) values(#{bmid})")
    int IFKchoose_mate(@Param("bmid") String bmid);
    //Vip
    @Insert("insert into vip(bmid) values(#{bmid})")
    int IFKvip(@Param("bmid") String bmid);

}
