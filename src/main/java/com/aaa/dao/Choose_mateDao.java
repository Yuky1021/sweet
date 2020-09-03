package com.aaa.dao;

import com.aaa.entity.Choose_mate;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Choose_mateDao extends tk.mybatis.mapper.common.Mapper<Choose_mate> {

    @Select("select * from choose_mate")
    public List<Choose_mate> listAll();

    @Insert("insert into choose_mate values(#{cm.lage},#{cm.bage},#{cm.height},#{cm.education},#{cm.marriage},#{cm.nation},#{cm.monthly},#{cm.bmid})")
    public Integer add(@Param("cm") Choose_mate choose_mate);

    @Update("update choose_mate" +
            "set lage=#{cm.lage}," +
            "    bage=#{cm.bage}," +
            "    height=#{cm.height}," +
            "    education=#{cm.education}," +
            "    marriage=#{cm.marriage}," +
            "    nation=#{cm.nation}," +
            "    monthly=#{cm.monthly}," +
            "    bmid=#{cm.bmid}" +
            "where cmid=#{cm.cmid}")
    public Integer update(@Param("cm") Choose_mate choose_mate);

    @Select("select c.cmid,c.lage,c.bage,c.height,c.education,c.marriage,c.nation,c.monthly,b.bmname from choose_mate c left join basic_message b on c.bmid=b.bmid")
    List<Map<String,Object>> findAll();

    //客户择偶标准表查询id
    @Select("select * from choose_mate where bmid=#{bmid}")
    List<Choose_mate> SelbyBmid(@Param("bmid") String bmid);

}
