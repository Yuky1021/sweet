package com.aaa.controller;

import com.aaa.dao.DisposeDao;
import com.aaa.entity.Dispose;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("dispose")
public class DisposeController {
    @Resource
    DisposeDao disposeDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return disposeDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return disposeDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Dispose dispose){
        System.out.println("update");
        return disposeDao.updateByPrimaryKey(dispose);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Dispose dispose){
        System.out.println("add");
        return disposeDao.insert(dispose);
    }
}
