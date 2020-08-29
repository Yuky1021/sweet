package com.aaa.controller;

import com.aaa.dao.MediaDao;
import com.aaa.entity.Media;
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
@RequestMapping("media")
public class MediaController {
    @Resource
    MediaDao mediaDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",mediaDao.listAll());
        return "login";
    }
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return mediaDao.findAll();

    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Media media){
        System.out.println("add");
        return mediaDao.insert(media);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Media media){
        System.out.println("update");
        return mediaDao.updateByPrimaryKey(media);
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return mediaDao.deleteByPrimaryKey(id);
    }


}
