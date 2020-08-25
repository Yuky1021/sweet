package com.aaa.controller;

import com.aaa.dao.PhotoDao;
import com.aaa.entity.Photo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("photo")
public class PhotoController {
    @Resource
    PhotoDao photoDao;
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return photoDao.listAll();
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return photoDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Photo photo){
        System.out.println("update");
        return photoDao.updateByPrimaryKey(photo);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Photo photo){
        System.out.println("add");
        return photoDao.insert(photo);
    }
}
