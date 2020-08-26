package com.aaa.controller;

import com.aaa.dao.Send_pasteDao;
import com.aaa.entity.Send_paste;
import com.aaa.entity.comment_paste;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("send_paste")
public class Send_pasteController {
    @Resource
    Send_pasteDao send_pasteDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return send_pasteDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return send_pasteDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Send_paste send_paste){
        System.out.println("update");
        return send_pasteDao.updateByPrimaryKey(send_paste);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Send_paste send_paste){
        System.out.println("add");
        return send_pasteDao.insert(send_paste);
    }

    @RequestMapping(value ="listByID",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> listByID(Integer id){
        System.out.println("listByID");
        return send_pasteDao.listByID(id);
    }
}

