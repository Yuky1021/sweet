package com.aaa.controller;

import com.aaa.dao.AttentionDao;
import com.aaa.entity.Attention;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("attention")
public class AttentionController {
    @Resource
    AttentionDao attentionDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return attentionDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return attentionDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Attention attention){
        System.out.println("update");
        return attentionDao.updateByPrimaryKey(attention);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Attention attention){
        System.out.println("add");
        return attentionDao.insert(attention);
    }
}
