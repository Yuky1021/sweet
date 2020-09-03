package com.aaa.controller;

import com.aaa.dao.Choose_mateDao;
import com.aaa.entity.Choose_mate;
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
@RequestMapping("choose_mate")
public class Choose_mateController {
    @Resource
    Choose_mateDao choose_mateDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",choose_mateDao.listAll());
        return "";
    }

    @RequestMapping("add")
    public String add(Choose_mate choose_mate){
        Integer count = choose_mateDao.add(choose_mate);
        return "";
    }

    @RequestMapping("update")
    public String update(Choose_mate choose_mate){
        Integer count = choose_mateDao.update(choose_mate);
        return "";
    }

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return choose_mateDao.findAll();

    }

    //根据cookie中Id查询详细信息
    @RequestMapping("Selmate")
    public String SelChoose(HttpServletRequest request, Model model){
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
        final List<Choose_mate> choose_mate;
        System.out.println(!bmid.equals("0"));
        if(!bmid.equals("0")) {
            choose_mate = choose_mateDao.SelbyBmid(bmid);
        }else {choose_mate=null;}
        System.out.println("查看全部信息"+choose_mate);
        model.addAttribute("Dlist",choose_mate.get(0));
        return "choose_mate";
    }

    //修改个人择偶信息
    @RequestMapping("UpdChoose")
    public String UpdChoose(Choose_mate det) {
        System.out.println("修改详细信息get");
        System.out.println(det);
        final int i = choose_mateDao.updateByPrimaryKey(det);
        System.out.println(i);
        if(i>0){System.out.println("UpdateYes");}
        return "redirect:Selmate";
    }

}
