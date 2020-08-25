package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.entity.Basic_message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("basic_message")
public class Basic_messageController {

    @Resource
    Basic_messageDao basic_messageDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",basic_messageDao.findAll());
        return "index";
    }

    @RequestMapping("findAllById")
    public String findAllById(Model model,Integer bmid){
        model.addAttribute("listId",basic_messageDao.findAllById(bmid));
        System.out.println(basic_messageDao.findAllById(bmid));
        return "single1";
    }

//   重定向:redirect
    //跳转登录页面
    @RequestMapping("tologin")
    public String toLogin(HttpServletRequest request){
        System.out.println("tologin------");
        final HttpSession session = request.getSession();
        final Object loginName = session.getAttribute("loginName");
        final Object loginPwd = session.getAttribute("loginPwd");
        System.out.println(loginName);
        System.out.println(loginPwd);
        return "login";
    }

    @RequestMapping("Login")
    public String Login(Basic_message bm, HttpServletRequest request,HttpServletResponse response,int checktf){
        //如果账号密码为空
        if (null == bm.getNumber() || null == bm.getPwd()) {
            return "redirect:/";
        }

        //查看账号密码是否正确
        //账号密码登录
        final int i = basic_messageDao.UPlogin(bm.getNumber(),bm.getPwd());
        //手机号密码登录
        final int j = basic_messageDao.PPlogin(bm.getNumber(),bm.getPwd());
        //登录成功保存用户名密码到session
        if(i==1||j==1){
            //存入session
            final HttpSession session = request.getSession();
            session.setAttribute("loginName", bm.getNumber());
            session.setAttribute("loginPwd", bm.getPwd());

            //如果选了复选框
            if(checktf==1) {
                //存入cookie
                Cookie NameCookie = new Cookie("lName", bm.getNumber());
                Cookie PwdCookie = new Cookie("lPwd", bm.getPwd());
                response.addCookie(NameCookie);
                response.addCookie(PwdCookie);
            }
            return "redirect:findAllById";
        }
        return "redirect:tologin";
    }
    //跳转注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("Register")
    public String Register(){
        System.out.println(2222222);
        return "register";
    }


    // 注销登录
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        //清空session
        request.getSession().invalidate();
        return "redirect:/";
    }


}
