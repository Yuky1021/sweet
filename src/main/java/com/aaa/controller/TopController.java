package com.aaa.controller;

import com.aaa.dao.TopDao;
import com.aaa.entity.Top;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Top")
public class TopController {
    @Resource
    TopDao topDao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Top> findAll(){
        System.out.println("findAll");
        return topDao.selectAll();
    }

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return topDao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Top top){
        System.out.println("update");
        return topDao.updateByPrimaryKey(top);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Top top){
        System.out.println("add");
        return topDao.insert(top);
    }

    //前台显示置顶套餐
    @RequestMapping("showtop")
    public String showtop(Model model){
        System.out.println("进入前台置顶套餐方法");
        List<Top> t=topDao.selectAll();
        System.out.println("前台置顶数据:"+t);
        model.addAttribute("ts",t);
        return "tops";
    }
}
