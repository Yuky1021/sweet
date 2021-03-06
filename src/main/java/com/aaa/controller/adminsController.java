package com.aaa.controller;

import com.aaa.dao.adminsDao;
import com.aaa.entity.admins;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("admin")
public class adminsController {

    @Resource
    adminsDao adminsdao;

    @RequestMapping("login")
    @ResponseBody
    public List<Map<String,Object>> login(String adname, String pwd){
        System.out.println(adminsdao.login(adname,pwd));
        return adminsdao.login(adname,pwd);
    }

    @RequestMapping(value ="findByName",produces = "application/json")
    @ResponseBody
    public List<admins> findByName(String adname){
        System.out.println(adminsdao.findByName(adname));
        return adminsdao.findByName(adname);
    }

    @RequestMapping(value ="updatePwd",produces = "application/json")
    @ResponseBody
    public int updatePwd(admins admin){
        System.out.println(admin);
        System.out.println(adminsdao.update(admin));
        return adminsdao.update(admin);
    }
}
