package com.aaa.controller;

import com.aaa.dao.activityDao;
import com.aaa.dao.applyDao;
import com.aaa.entity.apply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("apply")
public class applyController {

    @Resource
    applyDao applydao;
    @Resource
    activityDao activitydao;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<apply> findAll(){
        System.out.println("findAll");
        return applydao.selectAll();

}

    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return applydao.deleteByPrimaryKey(id);
    }

    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(apply apply){
        System.out.println("update");
        return applydao.updateByPrimaryKey(apply);
    }

    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(apply apply){
        System.out.println("add");
        return applydao.insert(apply);
    }
}
