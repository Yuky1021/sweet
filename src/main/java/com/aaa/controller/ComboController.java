package com.aaa.controller;

import com.aaa.dao.ComboDao;

import com.aaa.entity.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("combo")
public class ComboController {
    @Resource
    ComboDao comboDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Combo> findAll(){
        System.out.println("findAll");
        return comboDao.selectAll();
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Combo combo){
        System.out.println("add");
        return comboDao.insert(combo);
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return comboDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Combo combo){
        System.out.println("update");
        return comboDao.updateByPrimaryKey(combo);
    }
}
