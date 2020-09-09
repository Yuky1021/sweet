package com.aaa.controller;

import com.aaa.dao.Class_textDao;
import com.aaa.entity.Class_text;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("class_text")
public class Class_textController {

    @Resource
    Class_textDao class_textDao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Class_text> findAll(){
        System.out.println("findAll");
        return class_textDao.selectAll();
    }


    @RequestMapping(value="add",produces = "application/json")
    @ResponseBody
    public int add(Class_text class_text){
        System.out.println("add");
        return class_textDao.insert(class_text);
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return class_textDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Class_text class_text){
        System.out.println("update");
        return class_textDao.updateByPrimaryKey(class_text);
    }

    @RequestMapping("showTest")
    public String showTest(Model mo){
        //获取所有视频信息
        final List<Class_text> ct = class_textDao.selectAll();
        mo.addAttribute("ct",ct);
        System.out.println(ct);
        return "testClassroom";
    }

    @RequestMapping("Byctname")
    @ResponseBody
    public int selectByName(String ctname){
        return class_textDao.selectByName(ctname);
    }
}
