package com.aaa.dao;

import com.aaa.entity.Top;
import com.aaa.entity.Top_basic;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Top_basicDao extends tk.mybatis.mapper.common.Mapper<Top_basic> {


    //前台根据ID查询是否开通置顶
    @Select("select count(bmid) ct from top_basic where bmid=#{bmid}")
    Integer ById(@Param("bmid") String bmid);

    @Update("update top_basic set jstime=#{jstime} where bmid=#{bmid}")
    int Upd(Top_basic top);

    @Select("select * from top_basic where bmid=#{bmid}")
    Top_basic SelBybmid(String bmid);

    @Delete("delete from top_basic where bmid=#{bmid}")
    int Delbybmid(String bmid);
}
