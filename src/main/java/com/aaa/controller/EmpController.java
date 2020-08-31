package com.aaa.controller;


import com.aaa.dao.EmpDao;
import com.aaa.entity.Emp;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("emp")
public class EmpController {

    @Resource
    EmpDao empDao;


    @RequestMapping(value ="login",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> login(String ename,String epwd){
        System.out.println(empDao.login(ename,epwd));
        return empDao.login(ename,epwd);
    }

    @RequestMapping(value ="findAll",produces =" application/json")
    @ResponseBody
    public PageHelpers<Emp> findAll(PageHelpers<Emp> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Emp> emps = empDao.selectAll();
        ph.setRows(emps);
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(empDao.totalCount());
        System.out.println("totalCount:"+empDao.totalCount());
        return ph;
    }

//    @RequestMapping(value ="findAll",produces = "application/json")
//    @ResponseBody
//    public List<Emp> findAll(){
//        System.out.println("findAll");
//        return empDao.selectAll();
//    }
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

    @RequestMapping(value ="findBYState",produces = "application/json")
    @ResponseBody
    public List<Emp> findBYState(){
        System.out.println(empDao.findByState());
        return empDao.findByState();
    }

    @RequestMapping(value ="findByName",produces = "application/json")
    @ResponseBody
    public List<Emp> findByName(String ename){
        System.out.println(ename);
        System.out.println(empDao.findByName(ename));
        return empDao.findByName(ename);
    }

    @RequestMapping(value ="updatePwd",produces = "application/json")
    @ResponseBody
    public int updatePwd(Emp emp){
        System.out.println(emp);
        System.out.println(empDao.update(emp));
        return empDao.update(emp);
    }

}
