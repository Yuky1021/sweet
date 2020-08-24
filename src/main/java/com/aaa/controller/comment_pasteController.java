package com.aaa.controller;

import com.aaa.dao.comment_pasteDao;
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
@RequestMapping("comment_paste")
public class comment_pasteController {
    @Resource
    comment_pasteDao comment_pastedao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return comment_pastedao.findAll();

    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return comment_pastedao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(comment_paste comment_paste){
        System.out.println("update");
        return comment_pastedao.updateByPrimaryKey(comment_paste);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(comment_paste comment_paste){
        System.out.println("add");
        return comment_pastedao.insert(comment_paste);
    }
}
