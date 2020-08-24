package com.aaa.controller;

import com.aaa.dao.Profession_typeDao;
import com.aaa.entity.Profession_type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("profession_type")
public class Profession_typeController {
    @Resource
    Profession_typeDao profession_typeDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Profession_type> findAll(){
        System.out.println("findAll");
        return profession_typeDao.selectAll();
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Profession_type profession_type){
        System.out.println("add");
        return profession_typeDao.insert(profession_type);
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return profession_typeDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Profession_type profession_type){
        System.out.println("update");
        return profession_typeDao.updateByPrimaryKey(profession_type);
    }
}
