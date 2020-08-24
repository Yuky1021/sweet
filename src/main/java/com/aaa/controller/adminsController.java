package com.aaa.controller;

import com.aaa.dao.adminsDao;
import com.aaa.entity.admins;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("admin")
public class adminsController {

    @Resource
    adminsDao adminsdao;

    @RequestMapping("login")
    @ResponseBody
    public List<admins> login(admins admin){
        System.out.println(adminsdao.select(admin));
        return adminsdao.select(admin);
    }
}
