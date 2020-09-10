package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.dao.Pay_feesDao;
import com.aaa.dao.VipDao;
import com.aaa.entity.Pay_fees;
import com.aaa.entity.Vip;
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
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("vip")
public class VipController {
    @Resource
    VipDao vipDao;

    @Resource
    Pay_feesDao pay_feesDao;

    @Resource
    Basic_messageDao basic_messageDao;

    @RequestMapping(value = "findAll", produces = "application/json")
    @ResponseBody
    public List<Map<String, Object>> findAll() {
        System.out.println("findAll()");
        return vipDao.listAll();
    }

    @RequestMapping(value = "del", produces = "application/json")
    @ResponseBody
    public int del(Integer id) {
        System.out.println("del");
        return vipDao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "update", produces = "application/json")
    @ResponseBody
    public int update(Vip vip) {
        System.out.println("update");
        return vipDao.updateByPrimaryKey(vip);
    }

    @RequestMapping(value = "add", produces = "application/json")
    @ResponseBody
    public int add(Vip vip) {
        System.out.println("add");
        return vipDao.insert(vip);
    }

    //前台显示联系我们
    @RequestMapping("men")
    public String men() {
        return "relation";
    }

    //前台开通会员
    @RequestMapping("kthy")
    public String kthy(HttpServletRequest request, Vip vip, String coid, String coname, Integer price) {
        //获取当前登录人id
        System.out.println("coid:" + coid + " vip:" + vip);
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
        vip.setBmid(bmid);

        //创建记录对象用于保存缴费记录
        Pay_fees pay_fees = new Pay_fees();
        pay_fees.setBmid(Integer.valueOf(bmid));
        pay_fees.setPeoject("会员");
        pay_fees.setMoney(price);
        pay_fees.setPtime(coname);

        //获取当前日期转成字符串
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        System.out.println("时间:" + str);
        //设置缴费记录时间
        pay_fees.setPaytime(str);
        //截取月
        String s = str.substring(5, 7);
        System.out.println("截取后的时间月:" + s);
        //转成整数
        int myint = Integer.parseInt(s);
        System.out.println("转成整数后:" + myint);
        //开通一个月
        if (coid.equals("1")) {
            //当前月加上一个月
            int i = myint + 1;
            if (i > 12) {
                i = i - 12; // 2020 10 4 14  2021 2
                System.out.println("如果大于12月= i - 12:" + i);
                str = UpdYear(str);
            }
            //替换月份字符串
            String stri;
            if (i < 10) {
                stri = "0" + Integer.toString(i);
            } else {
                stri = Integer.toString(i);
            }
            str = str.replace(s, stri);
            System.out.println("改过后的日期字符串:" + str);
            //最终保存在数据库中的日期
            vip.setVtime(str);
        }
        if (coid.equals("2")) {
            //当前月加上三个月
            int i = myint + 3;
            if (i > 12) {
                i = i - 12; // 2020 10 4 14  2021 2
                System.out.println("如果大于12月= i - 12:" + i);
                str = UpdYear(str);
            }
            //替换月份字符串
            String stri;
            if (i < 10) {
                stri = "0" + Integer.toString(i);
            } else {
                stri = Integer.toString(i);
            }
            str = str.replace(s, stri);
            System.out.println("改过后的日期字符串:" + str);
            //最终保存在数据库中的日期
            vip.setVtime(str);
        }
        if (coid.equals("3")) {
            //加上一年
            str = UpdYear(str);
            vip.setVtime(str);
        }
        //判断之前有没有开通过会员
        Integer id = vipDao.ById(bmid);
        if (id != 1) {
            System.out.println("会员开通" + vip);
            int insert = vipDao.insert(vip);
            System.out.println(insert > 0 ? "成功" : "失败");
            System.out.println("设置个人信息中的VIP");
            int i = basic_messageDao.UpdVipBybmid(0, bmid);
            System.out.println("修改信息表VIP" + i);
        } else {
            System.out.println("会员续费" + vip);
            final int upd = vipDao.Upd(vip);
            System.out.println(upd > 0 ? "成功" : "失败");
        }


        System.out.println(pay_fees);
        //添加缴费记录
        final int insetPay = pay_feesDao.insert(pay_fees);
        System.out.println(insetPay > 0 ? "缴费记录保存成功" : "缴费记录保存失败");

        return "redirect:/basic_message/listAll";
    }

    //修改日期字符串年份加1
    public String UpdYear(String str) {
        //截取年份
        String nian = str.substring(0, 4);
        System.out.println("截取年份:" + nian);
        //当前年份转数字加1 2021
        int ni = Integer.valueOf(nian) + 1;
        System.out.println("截取过的年份加1年:" + ni);
        //替换年份字符串
        str = str.replaceFirst(nian, Integer.toString(ni));
        System.out.println("设置年份方法结果:" + str);
        return str;
    }

    @RequestMapping("VipTimelimit")
    @ResponseBody
    public int VipTimelimit(HttpServletRequest request) {
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
        //通过登录人的id查询vip表获取到期时间字符串
        Vip vips = vipDao.SelBybmid(bmid);
        System.out.println("vips:" + vips);
        if (vips != null) {
            String vtime = vips.getVtime();
            //字符串转日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date vdate = null;
            try {
                vdate = format.parse(vtime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Date date = new Date();
            System.out.println("vdate: " + vdate + " date:" + date);
            System.out.println(vdate.getTime() + "  " + date.getTime());
            //比较日期大小
            if (vdate.before(date)) {
                System.out.println("会员已到期");
                int delbybmid = vipDao.Delbybmid(bmid);
                int i = basic_messageDao.UpdVipBybmid(1, bmid);
                return 0;
            }
        };
        return 1;
    }

    //前台个人中心我的会员
    @RequestMapping("myvip")
    public String myvip(HttpServletRequest request, Model model){
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
        System.out.println("到期数据:"+vipdq);
        model.addAttribute("myvip",vipdq);
        return "vipdqtime";
    }
}
