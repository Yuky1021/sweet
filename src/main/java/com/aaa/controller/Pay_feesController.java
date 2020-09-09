package com.aaa.controller;

import com.aaa.dao.Pay_feesDao;
import com.aaa.entity.Pay_fees;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    @RequestMapping(value ="findAll",produces = "application/json")
//    @ResponseBody
//    public List<Map<String,Object>> findAll(){
//        System.out.println("findAll()");
//        return pay_feesDao.findAll();
//    }

    //分页
    @RequestMapping(value ="findAll",produces =" application/json")
    @ResponseBody
    public PageHelpers<Map<String,Object>> findAll(PageHelpers<Map<String,Object>> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Map<String,Object>> payfees = pay_feesDao.findAll();
        ph.setRows(payfees);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(payfees);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(pay_feesDao.totalCount());
        System.out.println("totalCount:"+pay_feesDao.totalCount());
        ph.setMoney(pay_feesDao.money());;
        System.out.println("money:"+pay_feesDao.money());
        return ph;
    }
}
