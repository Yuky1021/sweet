package com.aaa.dao;

import com.aaa.entity.Combo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ComboDao  extends tk.mybatis.mapper.common.Mapper<Combo> {

}
