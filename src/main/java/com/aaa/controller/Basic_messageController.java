package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.entity.Basic_message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
        final HttpSession session = request.getSession();
        final Object loginName = session.getAttribute("loginName");
        final Object loginPwd = session.getAttribute("loginPwd");
        System.out.println(loginName);
        System.out.println(loginPwd);
        return "login";
    }

    @RequestMapping("Login")
    public String Login(Basic_message bm, HttpServletRequest request){
        //如果账号密码为空
        if (null == bm.getNumber() || null == bm.getPwd()) {
            return "redirect:/";
        }
        //查看账号密码是否正确
        final int i = basic_messageDao.login(bm.getNumber(),bm.getPwd());
        System.out.println(i);

        //登录成功保存用户名密码到session
        if(i==1){
            final HttpSession session = request.getSession();
            session.setAttribute("loginName", bm.getNumber());
            session.setAttribute("loginPwd", bm.getPwd());
            return "redirect:findAllById";
        }
        return "redirect:/";
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




}
