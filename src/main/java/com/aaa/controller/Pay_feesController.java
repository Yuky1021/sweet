package com.aaa.controller;

import com.aaa.dao.Pay_feesDao;
import com.aaa.entity.Pay_fees;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class Pay_feesController {

    @Resource
    Pay_feesDao pay_feesDao;

    @RequestMapping("listAll")
    public String listAll(Model model){
        model.addAttribute("list",pay_feesDao.listAll());
        return "";
    }
}
