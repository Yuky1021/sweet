package com.aaa.controller;

import com.aaa.dao.Profession_typeDao;
import com.aaa.entity.Profession_type;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("profession_type")
public class Profession_typeController {

    @Resource
    Profession_typeDao profession_typeDao;

//    @RequestMapping(value ="findAll",produces = "application/json")
//    @ResponseBody
//    public List<Profession_type> findAll(){
//        System.out.println("findAll");
//        return profession_typeDao.selectAll();
//    }

    @RequestMapping(value ="findAll",produces =" application/json")
    @ResponseBody
    public PageHelpers<Profession_type> findAll(PageHelpers<Profession_type> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Profession_type> profession_types = profession_typeDao.selectAll();
        ph.setRows(profession_types);
        PageInfo<Profession_type> pageInfo = new PageInfo<Profession_type>(profession_types);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(profession_typeDao.totalCount());
        System.out.println("totalCount:"+profession_typeDao.totalCount());
        return ph;
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Profession_type profession_type){
        System.out.println("add");
        return profession_typeDao.insert(profession_type);
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return profession_typeDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Profession_type profession_type){
        System.out.println("update");
        return profession_typeDao.updateByPrimaryKey(profession_type);
    }
}
