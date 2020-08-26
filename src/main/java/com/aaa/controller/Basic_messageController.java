package com.aaa.controller;

import com.aaa.accessAPI.PhoneCode;
import com.aaa.dao.Basic_messageDao;
import com.aaa.entity.Basic_message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
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

    @RequestMapping(value ="ShowAll",produces = "application/json")
    @ResponseBody
    public List<Basic_message> ShowAll(){
        System.out.println(basic_messageDao.selectAll());
        return basic_messageDao.selectAll();
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
    //登录
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

            Cookie BmidCookie;
            if(i==1){
                final int bmid = basic_messageDao.getBmidByNumber(bm.getNumber());
                System.out.println("bmid:"+bmid);
                BmidCookie=new Cookie("bmid",Integer.toString(bmid));
                response.addCookie(BmidCookie);
            }
            if(j==1){
                final int bmid = basic_messageDao.getBmidByPhone(bm.getNumber());
                System.out.println("bmid:"+bmid);
                BmidCookie=new Cookie("bmid",Integer.toString(bmid));
                response.addCookie(BmidCookie);
            }

            //如果选了复选框
            if(checktf==1) {
                //存入cookie
                Cookie NameCookie = new Cookie("lName", bm.getNumber());
                Cookie PwdCookie = new Cookie("lPwd", bm.getPwd());
                response.addCookie(NameCookie);
                response.addCookie(PwdCookie);
            }
            return "redirect:listAll";
        }
        return "redirect:tologin";
    }

    //跳转注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }
    //注册
    @RequestMapping("Register")
    public String Register(Basic_message bm){
        String pwd=bm.getPwd();
        String phone=bm.getPhone();

        //生成账号
        String number="20"+phone.substring(5);
        //查找数据库中的数据条数
        int count = basic_messageDao.BMcount() + 1;
        number=number+count;
        System.out.println("number:"+number);
        //添加数据
        final int i = basic_messageDao.AddNPP(number, phone, pwd);
        if (i>0){System.out.println("成功"); }

        return "tologin";
    }

    //获取验证码
    @RequestMapping("getPhoneVerification")
    @ResponseBody
    public String getPhoneVerification(@Param("phone") String phone){
        final String Vcode = PhoneCode.getPhonemsg(phone);
        System.out.println(Vcode);
        return Vcode;
    }


    // 注销登录
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        //清空session
        request.getSession().invalidate();
        return "redirect:tologin";
    }


}
