package com.aaa.controller;

import com.aaa.dao.VipDao;
import com.aaa.entity.Vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("vip")
public class VipController {
    @Resource
    VipDao vipDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return vipDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return vipDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Vip vip){
        System.out.println("update");
        return vipDao.updateByPrimaryKey(vip);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Vip vip){
        System.out.println("add");
        return vipDao.insert(vip);
    }
}
