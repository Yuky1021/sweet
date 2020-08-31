package com.aaa.dao;

import com.aaa.entity.Dispose;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DisposeDao extends tk.mybatis.mapper.common.Mapper<Dispose> {
    @Select("select d.dsid,b.bmname as bname,d.types,d.reason,bm.bmname,d.state,d.way,d.dtime,e.ename from dispose d left join basic_message b on b.bmid=d.bid left join basic_message bm on bm.bmid=d.bmid left join emp e on e.emid=d.emid")
    List<Map<String,Object>> listAll();

    //添加z
    @Insert("insert into dispose (bid,types,reason,bmid) values(#{bid},#{types},#{reason},#{bmid})")
    Integer add(Dispose dispose);

    @Update("update dispose set state=#{state},way=#{way},dtime=now(),emid=#{emid} where dsid=#{dsid}")
    int update(Dispose dispose);

}
