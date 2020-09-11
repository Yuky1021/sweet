package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.dao.MessageDao;
import com.aaa.entity.Basic_message;
import com.aaa.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("message")
public class MessageController {
    @Resource
    MessageDao messageDao;
    @Resource
    Basic_messageDao basic_messageDao;

    //图片和内心独白校验
    public void setpics(List<Map<String, Object>> l) {
        for (Map<String, Object> a : l
        ) {
            Object p = a.get("pic");
            Object s = a.get("soliloquy");
            System.out.println("图片:" + p);
            System.out.println("内心独白:" + s);
            if (p == null || p.equals("")) {
                a.put("pic", "../images/timg3.jpg");
            }
            if (s == null || s.equals("")) {
                a.put("soliloquy", "暂未填写内心独白,暂未填写内心独白");
            }
        }
    }

    @RequestMapping(value = "findAll", produces = "application/json")
    @ResponseBody
    public List<Map<String, Object>> findAll() {
        System.out.println("findAll()");
        return messageDao.listAll();
    }

    @RequestMapping(value = "del", produces = "application/json")
    @ResponseBody
    public int del(Integer id) {
        System.out.println("del");
        return messageDao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "update", produces = "application/json")
    @ResponseBody
    public int update(Message message) {
        System.out.println("update");
        return messageDao.updateByPrimaryKey(message);
    }

    //前台主页面查询
    @RequestMapping("listAll")
    public String listAll(Model model) {
        List<Map<String, Object>> l = basic_messageDao.findAll();
        setpics(l);
        model.addAttribute("list", l);
        return "index";
    }

    //前台发送消息
    @RequestMapping("Add")
    @ResponseBody
    public Map<String, Object> Add(Message message, HttpServletRequest request) {
        System.out.println("进入前台发送消息方法");
        String bmid = "0";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("bmid")) {
                    bmid = cookie.getValue();
                }
            }
        }
        System.out.println("bmid:" + bmid);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println("时间:" + str);
        message.setFtime(str);
        message.setMstate(1);
        message.setTow(Integer.valueOf(bmid));
        final int im = messageDao.insert(message);
        Map<String,Object> m=new HashMap<String, Object>();
        m.put("time",str);
        m.put("con",message.getContext());
        if(im==1){
            return m;
        }
        return null;
    }

    //前台消息列表查询
    //前台消息列表查询
    @RequestMapping("qlists")
    public String qlists(HttpServletRequest request, Model model) {
        try {
            String bmid = "0";
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    System.out.println(cookie.getName());
                    if (cookie.getName().equals("bmid")) {
                        bmid = cookie.getValue();
                    }
                }
            }
            System.out.println("bmid:" + bmid);
            final List<Map<String, Object>> maps;
            System.out.println(!bmid.equals("0"));
            if (!bmid.equals("0")) {
                maps = messageDao.qlists(bmid);
                System.out.println("maps:" + maps);
            } else {
                maps = null;
            }

            model.addAttribute("qs", maps);
            model.addAttribute("bmid",bmid);
            System.out.println("消息列表查询:" + maps);
            //根据当前登陆人查询是否是会员
            List<Basic_message> vv=basic_messageDao.vipId(bmid);
            System.out.println("根据当前登陆人查询是否是会员信息:"+vv);
            model.addAttribute("sfvip",vv);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "lists";
    }


    //前台查看消息
    @RequestMapping("infos")
    @ResponseBody
    public List<Map<String, Object>> infos(String tow, HttpServletRequest request) {
        String bmid = "0";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("bmid")) {
                    bmid = cookie.getValue();
                }
            }
        }
        System.out.println("bmid:" + bmid);
        System.out.println("查看消息");
        List<Map<String, Object>> s = messageDao.infos(tow, bmid);
        System.out.println("消息:" + s);
        return s;
    }
    //前台发送消息
    @RequestMapping("add")
    public String add(Message message,HttpServletRequest request){
        System.out.println("进入前台发送消息方法");
        String bmid="0";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("bmid")){
                    bmid=cookie.getValue();
                }
            }
        }
        System.out.println("bmid:"+bmid);
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println("时间:"+str);
        message.setFtime(str);
        message.setMstate(1);
        message.setTow(Integer.valueOf(bmid));
        Integer count=messageDao.insert(message);
        return "redirect:qlists?bmid="+bmid;
    }

    @RequestMapping(value ="addmes",produces = "application/json")
    @ResponseBody
    public int add(String context,String one) {
        System.out.println("add");
        return messageDao.addMes(context, one);
    }
}
