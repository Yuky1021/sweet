package com.aaa.dao;

import com.aaa.entity.Vip;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface VipDao extends tk.mybatis.mapper.common.Mapper<Vip> {
    @Select("select v.vid,v.vtime,b.bmname from vip v left join basic_message b on v.bmid=b.bmid")
    List<Map<String,Object>> listAll();


    //前台开通会员
    @Select("insert into vip(bmid,jstime) values(#{bmid},#{jstime})")
    Integer add(Vip vip);
    //前台根据ID查询是否开通过会员
    @Select("select count(bmid) ct from vip where bmid=#{bmid}")
    Integer ById(@Param("bmid") String bmid);

    @Update("update vip set vtime=#{vtime} where bmid=#{bmid}")
    int Upd(Vip vip);

    @Select("select * from vip where bmid=#{bmid}")
    Vip SelBybmid(String bmid);

    @Delete("delete from vip where bmid=#{bmid}")
    int Delbybmid(String bmid);

    //前台查询个人中心我的会员什么时候到期
    @Select("select v.vtime,b.bmname,b.VIP from vip v left join basic_message b on v.bmid=b.bmid where v.bmid=#{bmid}")
    List<Map<String,Object>> vipdq(@Param("bmid") String bmid);
}
