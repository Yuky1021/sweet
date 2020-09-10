package com.aaa.controller;

import com.aaa.dao.Pay_feesDao;
import com.aaa.dao.TopDao;
import com.aaa.dao.Top_basicDao;
import com.aaa.entity.Pay_fees;
import com.aaa.entity.Top;
import com.aaa.entity.Top_basic;
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

@CrossOrigin
@Controller
@RequestMapping("Top")
public class TopController {
    @Resource
    TopDao topDao;
    @Resource
    Top_basicDao top_basicDao;
    @Resource
    Pay_feesDao pay_feesDao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Top> findAll(){
        System.out.println("findAll");
        return topDao.selectAll();
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return topDao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Top top){
        System.out.println("update");
        return topDao.updateByPrimaryKey(top);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Top top){
        System.out.println("add");
        return topDao.insert(top);
    }

    //前台显示置顶套餐
    @RequestMapping("showtop")
    public String showtop(Model model){
        System.out.println("进入前台置顶套餐方法");
        List<Top> t=topDao.selectAll();
        System.out.println("前台置顶数据:"+t);
        model.addAttribute("ts",t);
        return "tops";
    }
    //前台显示置顶套餐
    @RequestMapping("ktzd")
    public String ktzd(Model model,HttpServletRequest request, Top_basic top, String topid, String tname, Integer price){
        //获取当前登录人id
        System.out.println("topid:" + topid + " top:" + top);
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
        top.setBmid(bmid);

        //创建记录对象用于保存缴费记录
        Pay_fees pay_fees = new Pay_fees();
        pay_fees.setBmid(Integer.valueOf(bmid));
        pay_fees.setPeoject("置顶");
        pay_fees.setMoney(price);
        pay_fees.setPtime(tname);

        //获取当前日期转成字符串
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        System.out.println("时间:" + str);
        //设置缴费记录时间
        pay_fees.setPaytime(str);
        //截取月2020-09-09
        String s = str.substring(8);
        System.out.println("截取后的时间日:" + s);
        //转成整数
        int myint = Integer.parseInt(s);
        System.out.println("转成整数后:" + myint);
        //开通七天置顶
        System.out.println(topid.equals("2"));
        if (topid.equals("1")) {
            //当前月加上7天
            int i = myint + 7;
            if (i > 28) {
                i = i - 28; 
                System.out.println("如果大于28日= i - 28:" + i);
                str = UpdMonth(str);
            }
            //替换日字符串
            String stri;
            if (i < 10) {
                stri = "0" + Integer.toString(i);
            } else {
                stri = Integer.toString(i);
            }
            str=str.substring(0,4)+"-"+str.substring(5,7)+"-"+stri;
            System.out.println("改过后的日期字符串:" + str);
            //最终保存在数据库中的日期
            top.setJstime(str);
        }
        if (topid.equals("2")) {
            //当前月加上14天
            int i = myint + 14;
            if (i > 28) {
                i = i - 28;
                System.out.println("如果大于28日= i - 28:" + i);
                str = UpdMonth(str);
            }
            //替换日字符串
            String stri;
            if (i < 10) {
                stri = "0" + Integer.toString(i);
            } else {
                stri = Integer.toString(i);
            }
            str = str.replace(s, stri);
            str=str.replaceFirst(stri,s);
            System.out.println("改过后的日期字符串:" + str);
            //最终保存在数据库中的日期
            top.setJstime(str);
        }
        if (topid.equals("3")) {
            //加上一月
            str = UpdMonth(str);
            top.setJstime(str);
        }
        //判断是否处于置顶
        Integer id = top_basicDao.ById(bmid);
        if (id != 1) {
            System.out.println("置顶开通" + top);
            int insert = top_basicDao.insert(top);
            System.out.println(insert > 0 ? "成功" : "失败");
        } else {
            System.out.println("置顶续费" + top);
            final int upd = top_basicDao.Upd(top);
            System.out.println(upd > 0 ? "成功" : "失败");
        }


        System.out.println(pay_fees);
        //添加缴费记录
        final int insetPay = pay_feesDao.insert(pay_fees);
        System.out.println(insetPay > 0 ? "缴费记录保存成功" : "缴费记录保存失败");

        model.addAttribute("WIDout_trade_no",new Date().getTime());
        model.addAttribute("WIDsubject",pay_fees.getPeoject());
        model.addAttribute("WIDtotal_amount",pay_fees.getMoney());
        return "ceshi";
    }

    //修改日期字符串月份加1
    public String UpdMonth(String str) {
        //截取月份
        String nian = str.substring(5, 7);
        System.out.println("截取月份:" + nian);
        //当前份月转数字加1
        int ni = Integer.valueOf(nian) + 1;
        System.out.println("截取过的月加1:" + ni);
        if (ni > 12) {
            ni = ni - 12; // 2020 10 4 14  2021 2
            System.out.println("如果大于12月= ni - 12:" + ni);
            str = UpdYear(str);
        }
        String strni;
        if (ni < 10) {
            strni = "0" + Integer.toString(ni);
        } else {
            strni = Integer.toString(ni);
        }
        //替换月份字符串
        str =str.substring(0,4)+"-"+strni+"-"+str.substring(8);
        System.out.println("设置月份方法结果:" + str);
        return str;
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

    @RequestMapping("TopTimelimit")
    @ResponseBody
    public int TopTimelimit(HttpServletRequest request) {
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
        Top_basic vips = top_basicDao.SelBybmid(bmid);
        System.out.println("tops:" + vips);
        if (vips != null) {
            String vtime = vips.getJstime();
            //字符串转日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date vdate = null;
            try {
                vdate = format.parse(vtime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Date date = new Date();
            System.out.println("jdate: " + vdate + " date:" + date);
            System.out.println(vdate.getTime() + "  " + date.getTime());
            //比较日期大小
            if (vdate.before(date)) {
                System.out.println("置顶已到期");
                int delbybmid = top_basicDao.Delbybmid(bmid);
                System.out.println("delbybmid::"+delbybmid);
                return 0;
            }
        };
        return 1;
    }
}
