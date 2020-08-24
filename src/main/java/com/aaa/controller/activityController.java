package com.aaa.controller;

import com.aaa.dao.activityDao;
import com.aaa.entity.activity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Activity")
public class activityController {

    @Resource
    activityDao activatydao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<activity> findAll(){
        System.out.println("findAll");
        return activatydao.selectAll();
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return activatydao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(activity activity){
        System.out.println("update");
        return activatydao.updateByPrimaryKey(activity);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(activity activity){
        System.out.println("add");
        return activatydao.insert(activity);
    }

}
