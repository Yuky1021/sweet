package com.aaa.controller;

import com.aaa.dao.SuccessDao;
import com.aaa.entity.Success;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Success")
public class SuccessController {
    @Resource
    SuccessDao successDao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Success> findAll(){
        System.out.println("findAll");
        return successDao.selectAll();
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return successDao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Success success){
        System.out.println("update");
        return successDao.updateByPrimaryKey(success);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Success success){
        System.out.println("add");
        return successDao.insert(success);
    }

}
