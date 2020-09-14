package com.aaa.dao;

import com.aaa.entity.Basic_message;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Basic_messageDao extends tk.mybatis.mapper.common.Mapper<Basic_message> {


    //count
    @Select("select count(bmid) from basic_message")
    public int totalCount();
    //前台首页置顶
    @Select("select * from basic_message b left join details_message d on b.bmid=d.bmid left join top_basic t on b.bmid=t.bmid   where 1=1 and state=0 order by t.tbid desc limit 8")
    public List<Map<String,Object>> findAll();
    //根据用户状态查询
    @Select("select  * from basic_message where state=1")
    public List<Basic_message> findAllByStart();
    //前台找男友查询
    @Select("select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.sex=1")
    public List<Map<String,Object>> zhaoboy();
    //前台找女友
    @Select("select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.sex=0")
    public List<Map<String,Object>> zhaogirl();
    //根据ID查询
    @Select("select ds.*,bs.*,cm.*,lm.* from details_message ds left join basic_message bs on ds.bmid=bs.bmid left join choose_mate cm on bs.bmid=cm.bmid left join life_message lm on bs.bmid=lm.bmid where ds.bmid=#{bmid}")
    public List<Map<String,Object>> findAllById(@Param("bmid") Integer bmid);

    //用户密码登录
    @Select("SELECT COUNT(bmid) num FROM basic_message WHERE number=#{number} AND pwd=#{pwd} AND state=0")
    public int UPlogin(@Param("number") String number,@Param("pwd") String pwd);
    //手机号密码登录
    @Select("SELECT COUNT(bmid) num FROM basic_message WHERE phone=#{number} AND pwd=#{pwd} AND state=0")
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

    //根据手机号查询信息
    @Select("SELECT bmid,number,pwd FROM basic_message where phone=#{phone}")
    List<Basic_message> SelByPhone(@Param("phone") String phone);

    //客户基本信息表查询id!
    @Select("select * from basic_message where bmid=#{bmid}")
    List<Basic_message> SelbyBmid(@Param("bmid") String bmid);


    //前台首页显示男友
    @Select("select bs.*,ds.soliloquy,ds.pic from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.sex=1 limit 4")
    List<Map<String,Object>> findmen();

    @Update("update basic_message set vip=#{vip} where bmid=#{bmid}")
    int UpdVipBybmid(@Param("vip") int vip,@Param("bmid") String bmid);


    //前台根据当前登陆人id获取是否是会员
    @Select("select * from basic_message where bmid=#{bmid}")
    List<Basic_message> vipId(@Param("bmid") String bmid);

    //交往状态修改
    @Update("update basic_message set friendstate=#{friendstate},friendid=#{thisbmid} where bmid=#{hisId}")
    int QJWupd(@Param("hisId") String hisId,@Param("thisbmid") String thisbmid,@Param("friendstate") String friendstate);

    @Select("select count(bmid) from basic_message where friendstate=#{bmid}")
    int SelFriend(String bmid);

    //查询是否有交往请求
    @Select("select * from basic_message where number=#{number} and friendstate=1")
    Map<String,Object> Selbynumber(String number);

    @Select("select * from basic_message where bmid=#{friendid}")
    Map<String,Object> Selbyfriendid(String friendid);


    //前台注册回显账号
    @Select("select bmid,number,bmname,pwd from basic_message where phone=#{phone}")
    List<Basic_message> showNumber(@Param("phone") String phone);
}
