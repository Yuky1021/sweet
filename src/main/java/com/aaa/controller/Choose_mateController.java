package com.aaa.controller;

import com.aaa.dao.Choose_mateDao;
import com.aaa.entity.Choose_mate;
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
@RequestMapping("choose_mate")
public class Choose_mateController {
    @Resource
    Choose_mateDao choose_mateDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",choose_mateDao.listAll());
        return "";
    }

    @RequestMapping("add")
    public String add(Choose_mate choose_mate){
        Integer count = choose_mateDao.add(choose_mate);
        return "";
    }

    @RequestMapping("update")
    public String update(Choose_mate choose_mate){
        Integer count = choose_mateDao.update(choose_mate);
        return "";
    }

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
        return choose_mateDao.findAll();

    }

}
