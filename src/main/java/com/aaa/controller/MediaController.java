package com.aaa.controller;

import com.aaa.dao.MediaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
}
