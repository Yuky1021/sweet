package com.aaa.controller;

import com.aaa.dao.Pay_feesDao;
import com.aaa.entity.Pay_fees;
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
@RequestMapping("pay_fees")
public class Pay_feesController {

    @Resource
    Pay_feesDao pay_feesDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",pay_feesDao.listAll());
        return "";
    }
    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll()");
        return pay_feesDao.findAll();
    }
}
