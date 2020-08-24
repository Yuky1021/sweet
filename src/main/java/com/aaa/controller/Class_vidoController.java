package com.aaa.controller;

import com.aaa.dao.Class_vidoDao;
import com.aaa.entity.Class_vido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("class_vido")
public class Class_vidoController {
    @Resource
    Class_vidoDao class_vidoDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Class_vido> findAll(){
        System.out.println("findAll");
        return class_vidoDao.selectAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return class_vidoDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Class_vido class_vido){
        System.out.println("update");
        return class_vidoDao.updateByPrimaryKey(class_vido);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Class_vido class_vido){
        System.out.println("add");
        return class_vidoDao.insert(class_vido);
    }
}
