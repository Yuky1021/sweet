package com.aaa.dao;

import com.aaa.entity.life_message;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface life_messageDao extends Mapper<life_message> {

    @Select(" select lm.lmid,pt.ptname,lm.buyhouse,lm.buycar,lm.smoking,lm.drink,lm.city,lm.book,lm.hobby,bm.bmname  from life_message lm left join profession_type pt on pt.ptid=lm.ptid left join basic_message bm on bm.bmid=lm.bmid")
    List<Map<String,Object>>  listAll();
}