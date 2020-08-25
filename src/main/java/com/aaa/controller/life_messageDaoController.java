package com.aaa.controller;

import com.aaa.dao.life_messageDao;
import com.aaa.entity.life_message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("life_message")
public class life_messageDaoController {
    @Resource
    life_messageDao life_messagedao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return life_messagedao.listAll();
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return life_messagedao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(life_message life_message){
        System.out.println("update");
        return life_messagedao.updateByPrimaryKey(life_message);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(life_message life_message){
        System.out.println("add");
        return life_messagedao.insert(life_message);
    }


}
