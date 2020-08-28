package com.aaa.controller;

import com.aaa.dao.MediaDao;
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
}
