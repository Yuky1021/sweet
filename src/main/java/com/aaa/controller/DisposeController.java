package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import com.aaa.dao.DisposeDao;
import com.aaa.entity.Dispose;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Resource
    Basic_messageDao basic_messageDao;
    //前台添加
    @RequestMapping("tianjia")
    public String tianjia(Dispose dispose){
        System.out.println("进入tianjia方法");
        Integer count=disposeDao.add(dispose);
        System.out.println(count);
        return "redirect:listAll";
    }
    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",basic_messageDao.findAll());
        return "index";
    }
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println(disposeDao.listAll());
        return disposeDao.listAll();
    }

    @RequestMapping(value ="findByState",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findByState(){
        System.out.println(disposeDao.findByState());
        return disposeDao.findByState();
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
        return disposeDao.update(dispose);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Dispose dispose){
        System.out.println("add");
        return disposeDao.insert(dispose);
    }
}
