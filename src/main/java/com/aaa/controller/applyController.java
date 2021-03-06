package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.dao.activityDao;
import com.aaa.dao.applyDao;
import com.aaa.entity.Basic_message;
import com.aaa.entity.activity;
import com.aaa.entity.apply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping("apply")
public class applyController {

    @Resource
    applyDao applydao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return applydao.findAll();

    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println(applydao.deleteByPrimaryKey(id));
        System.out.println(id);
        Integer count=applydao.deleteByPrimaryKey(id);
        return count;
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(apply apply){
        System.out.println("update");
        return applydao.updateByPrimaryKey(apply);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(apply apply){
        System.out.println("add");
        return applydao.insert(apply);
    }
}
