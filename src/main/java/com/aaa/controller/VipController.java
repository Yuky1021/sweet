package com.aaa.controller;

import com.aaa.dao.VipDao;
import com.aaa.entity.Vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("vip")
public class VipController {
    @Resource
    VipDao vipDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return vipDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return vipDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Vip vip){
        System.out.println("update");
        return vipDao.updateByPrimaryKey(vip);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Vip vip){
        System.out.println("add");
        return vipDao.insert(vip);
    }

    //前台显示联系我们
    @RequestMapping("men")
    public String men(){
        return "relation";
    }

    //前台开通会员
    @RequestMapping("kthy")
    public String kthy(HttpServletRequest request,Vip vip,String coid){
        //获取当前登录人id
        String bmid="0";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName());
                if(cookie.getName().equals("bmid")){
                    bmid=cookie.getValue();
                }
            }
        }
        System.out.println("bmid:"+bmid);
        Integer id = vipDao.ById(bmid);
        //之前没有开通过会员
        if(id!=1){
            //获取当前日期转成字符串
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = format.format(date);
            System.out.println("时间:"+str);
            //2020-12-11 11:12:10
            //截取月
            String s = str.substring(5, 2);
            System.out.println("截取后的时间月:"+s);
            //转成整数
            int myint = Integer.parseInt(s);
            System.out.println("转成整数后:"+myint);
            //开通一个月
            if(coid.equals(1)){
                int i = myint + 1;
                if(i>12){
                    int yue = i - 12;

                }
                String s2 = str.replace(s, Integer.toString(i));
                System.out.println("改过后:"+s2);
            }

        }else{

        }
        vip.setBmid(bmid);

        return "";
    }

}
