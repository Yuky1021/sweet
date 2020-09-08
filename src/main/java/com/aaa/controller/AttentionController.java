package com.aaa.controller;

import com.aaa.dao.AttentionDao;
import com.aaa.dao.Basic_messageDao;
import com.aaa.entity.Attention;
import com.aaa.entity.Dispose;
import com.aaa.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("attention")
public class AttentionController {
    @Resource
    AttentionDao attentionDao;
    @Resource
    Basic_messageDao basic_messageDao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return attentionDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return attentionDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Attention attention){
        System.out.println("update");
        return attentionDao.updateByPrimaryKey(attention);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Attention attention){
        System.out.println("add");
        return attentionDao.insert(attention);
    }

    public void setpics( List<Map<String,Object>> l){
        try {
            for (Map<String,Object> a : l
            ) {
                Object p=a.get("pic");
                Object s = a.get("soliloquy");
                System.out.println("图片:"+p);
                System.out.println("内心独白:"+s);
                if(p==null || p.equals("")){
                    a.put("pic","../images/timg3.jpg");
                }
                if(s==null || s.equals("")){
                    a.put("soliloquy","暂未填写内心独白,暂未填写内心独白");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //首页
    @RequestMapping("listAll")
    public String listAll(Model model){
        try{
            List<Map<String,Object>> l=basic_messageDao.findAll();
            setpics(l);
            model.addAttribute("list",l);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    //前台关注客户
    @RequestMapping("guanzhur")
    public String guanzhur(Attention attention, HttpServletRequest request){
        try {
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
            attention.setAid(bmid);
            System.out.println("进入前台关注方法");
            System.out.println(attention);
            Integer count=attentionDao.insert(attention);
            System.out.println("添加条数:"+count);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:mygz";
    }
    //前台我的关注
    @RequestMapping("mygz")
    public String mygz(Model model,HttpServletRequest request){
        try {
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
            System.out.println("进入前台我的粉丝方法");
            List<Map<String,Object>> m= attentionDao.myqguanzhu(bmid);
            System.out.println(attentionDao.myqguanzhu(bmid));
            model.addAttribute("my",m);
            //我的粉丝
            List<Map<String,Object>>r=attentionDao.myqgzr(bmid);
            System.out.println("我的粉丝:"+r);
            model.addAttribute("myr",r);
            //前台统计我的关注个数
            Integer integer = attentionDao.counts(bmid);
            System.out.println("个数:"+integer);
            model.addAttribute("gss",integer);
            //前台统计我的粉丝个数
            Integer fcount = attentionDao.fcount(bmid);
            System.out.println("粉丝个数:"+fcount);
            model.addAttribute("fcs",fcount);
        }catch (Exception ex){

        }
        return "atten";
    }

    //前台所有
    @RequestMapping("search")
    public String search(Model model){
        try {
            System.out.println("进入前台模糊查询");
            List<Map<String,Object>> mhs=attentionDao.mhfind();
            System.out.println("数据:"+mhs);
            model.addAttribute("mh",mhs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "seek";
    }
    //前台查询昵称或者id2
    @RequestMapping("mhncid2")
    public String mhncid2(String params,Model model){
        System.out.println("进入方法2");
        try {
            //获取昵称
            List<Map<String, Object>> n=attentionDao.mhname(params);
            System.out.println("n:"+n);
            //获取id
            List<Map<String, Object>> d=attentionDao.mhber(params);
            System.out.println("d:"+d);
            if(n.size()!=0){
                model.addAttribute("mh",n);
            }
            if(d.size()!=0){
                model.addAttribute("mh",d);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "seek";
    }

    //前台模糊搜索
    @RequestMapping("much")
    public String much(Model model,Integer height,Integer sex,Integer monthly,String education,Integer marriage){
        System.out.println("进入前台模糊搜索");
        System.out.println(height +" SEX;" +sex+" MONTHLY:" +monthly+" EDUCATION:" +education+" Marriage:" +marriage);
        List<Map<String, Object>> list = attentionDao.mulit(height, sex, monthly, education, marriage);
        System.out.println("多个数据:"+list);
        model.addAttribute("mh",list);
        return "seek";
    }


    //校验关注提示已经关注过了
    @RequestMapping("jygzr")
    @ResponseBody
    public Integer jygzr(HttpServletRequest request,String baid){
            //从cook中获取当前登录人id
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
            //判断是否是自己关注自己
            if(bmid.equals(baid)){
                return 1;
            }
        List<Map<String,Object>> is = attentionDao.jycf(baid, bmid);
        System.out.println("关注是否重复数据:"+is.size());
        //判断是否重复关注
        if(is.size()>0){
            return 2;
        }
        return 0;
    }
    //校验自己不能给自己发消息
    @RequestMapping("jyinfos")
    @ResponseBody
    public Integer jyinfos(HttpServletRequest request,String one){
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
        if (one.equals(bmid)){
            return 1;
        }
        return 0;
    }
    //校验不能重复举报
    @RequestMapping("jyjbs")
    @ResponseBody
    public Integer jyjbs(HttpServletRequest request,String bid){
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
        List<Dispose> list = attentionDao.jyjb(bid, bmid);
        //如果查询到数据就代表你已经举报过来
        if(list.size()>0){
            return 1;
        }
        return 0;
    }
}
