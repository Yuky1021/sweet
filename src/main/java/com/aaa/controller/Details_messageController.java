package com.aaa.controller;

import com.aaa.dao.Details_messageDao;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("details_message")
public class Details_messageController {
    @Resource
    Details_messageDao details_messageDao;

//    @RequestMapping(value ="findAll",produces = "application/json")
//    @ResponseBody
//    public PageHelpers<Map<String,Object>> findAll(PageHelpers<Map<String,Object>> ph){
//        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
//        List<Map<String,Object>> details_messages = details_messageDao.findAll();
//        ph.setRows(details_messages);
//        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(details_messages);
//        int pages = pageInfo.getPages();
//        ph.setLastPage(pages);
//        ph.setTotalCount(details_messageDao.totalCount());
//        System.out.println("totalCount:"+details_messageDao.totalCount());
//        return ph;
//    }

   @RequestMapping(value ="findAll",produces = "application/json")
   @ResponseBody
    public List<Map<String,Object>> findAll(){
        System.out.println("findAll");
       return details_messageDao.findAll();

   }
}
