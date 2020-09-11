package com.aaa.controller;

import com.aaa.accessAPI.PhoneCode;
import com.aaa.dao.Basic_messageDao;
import com.aaa.dao.ForeignKeyAddDao;
import com.aaa.dao.Top_basicDao;
import com.aaa.dao.VipDao;
import com.aaa.entity.Basic_message;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("basic_message")
public class Basic_messageController {

    @Resource
    Basic_messageDao basic_messageDao;
    @Resource
    ForeignKeyAddDao fkd;
    @Resource
    VipDao vipDao;
    @Resource
    Top_basicDao top_basicDao;
    //校验如果没有图片设置默认图片，如果没有内心独白设置默认内心独白
    public void setpics( List<Map<String,Object>> l){
        for (Map<String,Object> a : l
        ) {
            Object p=a.get("pic");
            Object s = a.get("soliloquy");
            System.out.println("图片:"+p);
            System.out.println("内心独白:"+s);
            if(p==null||p.equals("")){
                a.put("pic","../images/timg3.jpg");
            }
            if(s==null||s.equals("")){
                a.put("soliloquy","暂未填写内心独白");
            }
        }
    }

    @RequestMapping(value ="ShowAll",produces = "application/json")
    @ResponseBody
    public PageHelpers<Basic_message> findAll(PageHelpers<Basic_message> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Basic_message> basic_messages = basic_messageDao.selectAll();
        ph.setRows(basic_messages);
        PageInfo<Basic_message> pageInfo = new PageInfo<Basic_message>(basic_messages);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(basic_messageDao.totalCount());
        System.out.println("totalCount:"+basic_messageDao.totalCount());
        return ph;
    }

    @RequestMapping(value ="ShowBystate",produces = "application/json")
    @ResponseBody
    public List<Basic_message> ShowBystate(){
        System.out.println(basic_messageDao.findAllByStart());
        return basic_messageDao.findAllByStart();
    }

    //前台首页置顶
    @RequestMapping("listAll")
    public String listAll(Model model){
        List<Map<String,Object>> l=basic_messageDao.findAll();
        setpics(l);
        model.addAttribute("list",l);
        return "index";
    }

    //前台找男友
    @RequestMapping("zhaoboy")
    public String zhaoboy(Model model){
        List<Map<String, Object>> gs = basic_messageDao.zhaoboy();
        setpics(gs);
        model.addAttribute("boys",gs);
        return "boyfriend";
    }

    //前台找女友
    @RequestMapping("zhaogirl")
    public String zhaogirl(Model model){
        List<Map<String,Object>> gs=basic_messageDao.zhaogirl();
        setpics(gs);
        model.addAttribute("girls",gs);
        return "girlfriend";
    }

    //前台详情
    @RequestMapping("findAllById")
    public String findAllById(HttpServletRequest request,Model model,@Param("bmid") Integer bmid){

        //获取当前登录人id
        String bmids = "0";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("bmid")) {
                    bmids = cookie.getValue();
                }
            }
        }
        System.out.println("当前登陆人:" + bmids);

        System.out.println("bid:"+bmid);
        List<Map<String,Object>> fid=basic_messageDao.findAllById(bmid);
        setpics(fid);
        model.addAttribute("listId",fid);
        System.out.println(basic_messageDao.findAllById(bmid));

        //根据当前登陆人查询是否是会员
        List<Basic_message> vv=basic_messageDao.vipId(bmids);
        System.out.println("根据当前登陆人查询是否是会员信息:"+vv);
        model.addAttribute("sfvip",vv);
        return "single1";
    }
    //前台根据id进入举报页面
    @RequestMapping("findAllByIdt")
    public String findAllByIdt(HttpServletRequest request,Model model,@Param("bmid") Integer bmid){
        System.out.println("bid:"+bmid);
        //获取当前登录人id
        String bmids = "0";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("bmid")) {
                    bmids = cookie.getValue();
                }
            }
        }
        System.out.println("当前登陆人:" + bmids);
        model.addAttribute("typess",basic_messageDao.findAllById(bmid));
        System.out.println(basic_messageDao.findAllById(bmid));
        //根据当前登陆人查询是否是会员
        List<Basic_message> vv=basic_messageDao.vipId(bmids);
        System.out.println("根据当前登陆人查询是否是会员信息:"+vv);
        model.addAttribute("sfvip",vv);
        return "contact";

    }

    //   重定向:redirect
    //跳转登录页面
    @RequestMapping("tologin")
    public String toLogin(HttpServletRequest request,Model model,String mimacw){
        System.out.println("tologin------");
        final HttpSession session = request.getSession();
        final Object loginName = session.getAttribute("loginName");
        final Object loginPwd = session.getAttribute("loginPwd");
        System.out.println(loginName);
        System.out.println(loginPwd);
        System.out.println("mimacw"+mimacw+" "+(mimacw!=null));
        if (mimacw!=null){
            model.addAttribute("mimacw","账号密码不正确");
        }
        return "login";
    }

    @RequestMapping("Login")
    public String Login(Basic_message bm, HttpServletRequest request,HttpServletResponse response,int checktf,Model model){
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
            if(i==1){
                System.out.println(bm.getNumber());
                final int bmid = basic_messageDao.getBmidByNumber(bm.getNumber());
                System.out.println("bmid:"+bmid);
                Cookie BmidCookie=new Cookie("bmid",Integer.toString(bmid));
                BmidCookie.setPath("/");
                response.addCookie(BmidCookie);
                System.out.println(3);
            }
            if(j==1){
                final int bmid = basic_messageDao.getBmidByPhone(bm.getNumber());
                System.out.println("bmid:"+bmid);
                Cookie BmidCookie=new Cookie("bmid",Integer.toString(bmid));
                BmidCookie.setPath("/");
                response.addCookie(BmidCookie);
                System.out.println(4);
            }

            //如果选了复选框
            if(checktf==1) {
                //存入cookie

                Cookie NameCookie = new Cookie("lName", bm.getNumber());
                Cookie PwdCookie = new Cookie("lPwd", bm.getPwd());
                response.addCookie(NameCookie);
                response.addCookie(PwdCookie);
            }
            System.out.println(5);
            return "redirect:listAll";
        }
        model.addAttribute("mimacw","账号密码不正确");
        return "redirect:tologin";
    }

    //跳转注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("Register")
    public String Register(Basic_message bm){
        //生成账号
        String number="20";
        String p=bm.getPhone();
        number=number+p.substring(5);
        final int i = basic_messageDao.BMcount();
        number=number+i;

        //注册
        basic_messageDao.AddNPP(number,p,bm.getPwd());
        final List<Basic_message> bm2 = basic_messageDao.SelByPhone(p);
        System.out.println("bm2:"+bm2);
        String bmid=bm2.get(0).getBmid().toString();
        System.out.println(bmid);
        //生成关联的信息表外键列
        fkd.IFKchoose_mate(bmid);
        fkd.IFKdetails_message(bmid);
        fkd.IFKlife_message(bmid);
        fkd.IFKvip(bmid);


        return "redirect:tologin";
    }


    //查询手机号是否重复
    @RequestMapping("isPhone")
    @ResponseBody
    public String isPhone(String phone){
        final int phoneTrue = basic_messageDao.isPhoneTrue(phone);
        return Integer.toString(phoneTrue);
    }
    //获取验证码
    @RequestMapping("getPhoneVerification")
    @ResponseBody
    public String getPhoneVerification(String phone){
        final String Vcode = PhoneCode.getPhonemsg(phone);
        System.out.println(Vcode);
        return Vcode;
    }
    //找回账号密码
    @RequestMapping("Zhzzmm")
    public String Zhzzmm(@Param("modPhone") String modPhone,Model mo){
        final List<Basic_message> bm = basic_messageDao.SelByPhone(modPhone);
        //如果查询账号大于0
        if(bm.size()>0){
            final Basic_message bm1 = bm.get(0);
            mo.addAttribute("bm",bm1);
            return "numberAndpwd";
        }
        mo.addAttribute("Eorr","该手机号未注册");
        return "login";
    }
    // 注销登录
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        //清空session
        request.getSession().invalidate();
        return "redirect:/";
    }

    //显示个人中心
    @RequestMapping("/GeRen")
    public String GeRen(HttpServletRequest request,Model model) {
        System.out.println("个人中心get");
        //获取当前登录人id
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
        List<Map<String, Object>> vipdq = vipDao.vipdq(bmid);
        System.out.println("点个人中心GeRen到期数据:"+vipdq);
        model.addAttribute("myvip",vipdq);
        List<Map<String,Object>> zds=top_basicDao.sfzd(bmid);
        System.out.println("点个人中心GeRen置顶数据:"+zds);
        model.addAttribute("zd",zds);
        return "GeRen";
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Basic_message basic_message){
        System.out.println("update");
        return basic_messageDao.updateByPrimaryKey(basic_message);
    }

    //根据cookie中Id查询详细信息
    @RequestMapping("Selmate")
    public String SelBasic(HttpServletRequest request, Model model){
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
        final List<Basic_message> basic_message;
        System.out.println(!bmid.equals("0"));
        if(!bmid.equals("0")) {
            basic_message = basic_messageDao.SelbyBmid(bmid);
        }else {basic_message=null;}
        System.out.println("查看全部信息"+basic_message);
        model.addAttribute("Dlist",basic_message.get(0));
        return "basic_message";
    }

    //修改个人基本信息
    @RequestMapping("UpdBasic")
    public String UpdBasic(Basic_message det) {
        System.out.println("修改详细信息get!");
        System.out.println(det);
        final int i = basic_messageDao.updateByPrimaryKey(det);
        System.out.println(i);
        if(i>0){System.out.println("UpdateYes");}
        return "redirect:Selmate";
    }

    //前台首页显示男友
    @RequestMapping("showMen")
    public String showMen(HttpServletRequest request){
        try{
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

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "index";
    }

    ////前台根据当前登陆人id获取是否是会员

}
