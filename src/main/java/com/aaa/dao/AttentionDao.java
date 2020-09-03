package com.aaa.dao;

import com.aaa.entity.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttentionDao extends tk.mybatis.mapper.common.Mapper<Attention> {
    @Select("select att.attid,bm.bmname as bname,bg.bmname from attention att left join basic_message bm on bm.bmid=att.baid left join basic_message bg on bg.bmid=att.aid")
    List<Map<String,Object>> listAll();

    //前台查询我的关注
    @Select("select at.*,dm.pic,bm.bmname,bm.address  from attention at left join basic_message bm on at.baid=bm.bmid left join details_message dm on bm.bmid=dm.dmid where at.aid=#{aid}")
    List<Map<String,Object>> myqguanzhu(@Param("aid") String aid);

    //前台查询我的粉丝
    @Select("select at.*,dm.pic,bm.bmname,bm.address  from attention at left join basic_message bm on at.aid=bm.bmid left join details_message dm on bm.bmid=dm.dmid where at.baid=#{baid}")
    List<Map<String,Object>> myqgzr(@Param("baid") String baid);

    //前台我的关注个数
    @Select("select count(attid) gs from attention where aid=#{gsid}")
    Integer counts(@Param("gsid") String gsid);
    //前台我的粉丝个数
    @Select("select count(attid) gs from attention where baid=#{baid}")
    Integer fcount(@Param("baid") String baid);
    //前台查询所有
    @Select("select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid")
    List<Map<String,Object>> mhfind();
    //前台查询昵称
    @Select("select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.bmname=#{bmname}")
    List<Map<String,Object>> mhname(@Param("bmname") String bmname);
    //前台查询ID
    @Select("select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid where bs.number=#{number}")
    List<Map<String,Object>> mhber(@Param("number") String number);
    //前台模糊搜索
    @Select("<script>" +
            "select bs.*,ds.* from basic_message bs left join details_message ds on bs.bmid=ds.bmid " +
            "<where>" +
            "   <if test=\"height!=1\" > and  height &gt;= #{height} and height &lt; #{height}+10 </if> " +
            "   <if test=\"sex!=2\" > and sex=#{sex} </if> " +
            "   <if test=\"monthly!=4 and monthly!=10000\" > and monthly &gt;= #{monthly} and monthly &lt; #{monthly}+2000 </if>" +
            "   <if test=\"monthly==10000\" > and monthly &gt;= #{monthly} </if>" +
            "   <if test=\"education!='随便'\" > and  education=#{education} </if> " +
            "   <if test=\"marriage!=5\" > and marriage=#{marriage} </if>" +
            "</where>" +
            "</script>")
    List<Map<String,Object>> mulit(@Param("height") Integer height,@Param("sex") Integer sex,@Param("monthly") Integer monthly,@Param("education") String education,@Param("marriage") Integer marriage);
}
