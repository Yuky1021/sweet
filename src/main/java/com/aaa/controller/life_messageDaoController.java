package com.aaa.controller;

import com.aaa.dao.life_messageDao;
import com.aaa.entity.life_message;
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

//    @RequestMapping(value ="findAll",produces = "application/json")
//    @ResponseBody
//    public PageHelpers<Map<String,Object>> findAll(PageHelpers<Map<String,Object>> ph){
//        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
//        List<Map<String,Object>> lift_messages = life_messagedao.listAll();
//        ph.setRows(lift_messages);
//        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(lift_messages);
//        int pages = pageInfo.getPages();
//        ph.setLastPage(pages);
//        ph.setTotalCount(life_messagedao.totalCount());
//        System.out.println("totalCount:"+life_messagedao.totalCount());
//        return ph;
//    }

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
