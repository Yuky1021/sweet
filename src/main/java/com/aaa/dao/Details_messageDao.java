package com.aaa.dao;

import com.aaa.entity.Details_message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Details_messageDao extends tk.mybatis.mapper.common.Mapper<Details_message> {

    @Select("select * from details_message where bmid=#{bmid}")
    List<Details_message> SelbyBmid(@Param("bmid") String bmid);



    //前台首页根据id查询
    @Select("select bm.bmid,bm.bmname,dm.pic,bm.number from details_message dm left join basic_message bm on dm.dmid=bm.bmid where bm.bmid=#{bmid}")
    List<Map<String,Object>> showajid(@Param("bmid") String bmid);


}
