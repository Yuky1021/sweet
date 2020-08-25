package com.aaa.controller;

import com.aaa.dao.MessageDao;
import com.aaa.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("message")
public class MessageController {
    @Resource
    MessageDao messageDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return messageDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return messageDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Message message){
        System.out.println("update");
        return messageDao.updateByPrimaryKey(message);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Message message){
        System.out.println("add");
        return messageDao.insert(message);
    }
}
