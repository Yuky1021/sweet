package com.aaa.dao;

import com.aaa.entity.Basic_message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Basic_messageDao extends tk.mybatis.mapper.common.Mapper<Basic_message> {

    //查询
    @Select("select bs.*,ds.soliloquy,ds.pic from basic_message bs left join details_message ds on bs.bmid=ds.bmid limit 4")
    public List<Map<String,Object>> findAll();

    //根据ID查询
    @Select("select bs.*,ds.soliloquy,ds.pic,ds.truename from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.bmid=#{bmid}")
    public List<Map<String,Object>> findAllById(@Param("bmid") Integer bmid);

    //用户密码登录
    @Select("SELECT COUNT(bmid) num FROM basic_message WHERE number=#{number} AND pwd=#{pwd}")
    public int UPlogin(@Param("number") String number,@Param("pwd") String pwd);
    //手机号密码登录
    @Select("SELECT COUNT(bmid) num FROM basic_message WHERE phone=#{number} AND pwd=#{pwd}")
    public int PPlogin(@Param("number") String number,@Param("pwd") String pwd);

    //根据电话查询id
    @Select("SELECT bmid FROM basic_message WHERE phone=#{phone}")
    public int getBmidByPhone(@Param("phone") String phone);
    //根据账号查询id
    @Select("SELECT bmid FROM basic_message WHERE number=#{number}")
    public int getBmidByNumber(@Param("number") String number);

    //注册
    @Insert("insert into basic_message(number,phone,pwd) values(#{number},#{phone},#{pwd})")
    public int AddNPP(@Param("number") String number,@Param("phone") String phone,@Param("pwd") String pwd);

    //查询数据条数
    @Select("SELECT count(bmid) FROM basic_message")
    public int BMcount();

    //查询手机号是否重复
    @Select("SELECT count(bmid) FROM basic_message where phone=#{phone}")
    int isPhoneTrue(@Param("phone") String phone);
}
