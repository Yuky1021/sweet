package com.aaa.controller;


import com.aaa.dao.EmpDao;
import com.aaa.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    EmpDao empDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Emp> findAll(){
        System.out.println("findAll");
        return empDao.selectAll();
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Emp emp){
        System.out.println("add");
        return empDao.insert(emp);
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return empDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Emp emp){
        System.out.println("update");
        return empDao.updateByPrimaryKey(emp);
    }
}
