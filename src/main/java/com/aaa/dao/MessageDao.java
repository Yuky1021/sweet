package com.aaa.dao;

import com.aaa.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageDao extends tk.mybatis.mapper.common.Mapper<Message> {
    @Select("select me.meid,bm.bmname as bname,bg.bmname,me.context from message me left join basic_message bm on bm.bmid=me.one left join basic_message bg on bg.bmid=me.tow")
    List<Map<String,Object>> listAll();

    //前台消息列表
    /*@Select("select m.*,bm.bmid,bm.bmname,bm.age,bm.address,bm.height,dm.dmid,dm.pic,count(tow) ct from message m left join basic_message bm on m.one=bm.bmid left join details_message dm on m.tow=dm.dmid where m.one=#{one} or m.tow=#{one} group by tow")*/
    @Select("select m.*,bm.bmid,bm.bmname,bm.age,bm.address,bm.height,bm.VIP,dm.dmid,dm.pic,count(tow) ct from message m left join basic_message bm on if(m.tow=#{one},m.one=bm.bmid ,m.tow=bm.bmid ) left join details_message dm on bm.bmid=dm.bmid where m.one=#{one} or m.tow=#{one} group by tow,one having m.tow is not null")
    List<Map<String,Object>> qlists(@Param("one") String one);

    //前台查询消息
    @Select("select m.*,b.bmname,(case when one=#{one} then (0) else(1) end) state from message m left join basic_message b on m.tow=b.bmid where one=#{one} and tow=#{tow} or one=#{tow} and tow=#{one} order by ftime")
    List<Map<String,Object>> infos(@Param("tow") String tow,@Param("one") String one);

    @Insert("insert into message(one,tow,context,ftime,mstate) values (#{one},null,#{context},now(),1)")
   int addMes(@Param("context") String context,@Param("one") String one);

    @Select("select * from message where tow is null and one=#{one}")
    List<Message> Selmsg(@Param("one") String one);
}
