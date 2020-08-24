package com.aaa.controller;

import com.aaa.dao.Basic_messageDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("basic_message")
public class Basic_messageController {

    @Resource
    Basic_messageDao basic_messageDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",basic_messageDao.findAll());
        return "index";
    }

    @RequestMapping("findAllById")
    public String findAllById(Model model,Integer bmid){
        model.addAttribute("listId",basic_messageDao.findAllById(bmid));
        System.out.println(basic_messageDao.findAllById(bmid));
        return "single1";
    }

}
