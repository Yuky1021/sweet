package com.aaa.controller;

import com.aaa.dao.Send_pasteDao;
import com.aaa.dao.comment_pasteDao;
import com.aaa.entity.Send_paste;
import com.aaa.entity.comment_paste;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("send_paste")
public class Send_pasteController {
    @Resource
    Send_pasteDao send_pasteDao;
    @Resource
    comment_pasteDao cp;


    @RequestMapping(value ="findAll",produces =" application/json")
    @ResponseBody
    public PageHelpers<Map<String,Object>> findAll(PageHelpers<Map<String,Object>> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Map<String,Object>> pastes = send_pasteDao.listAll();
        ph.setRows(pastes);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(pastes);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(send_pasteDao.totalCount());
        System.out.println("totalCount:"+send_pasteDao.totalCount());
        return ph;
    }
    @RequestMapping(value ="del",produces = "application/json")
    @ResponseBody
    public int del(Integer id){
        System.out.println("del");
        return send_pasteDao.deleteByPrimaryKey(id);
    }
    @RequestMapping(value ="update",produces = "application/json")
    @ResponseBody
    public int update(Send_paste send_paste){
        System.out.println("update");
        return send_pasteDao.updateByPrimaryKey(send_paste);
    }
    @RequestMapping(value ="add",produces = "application/json")
    @ResponseBody
    public int add(Send_paste send_paste){
        System.out.println("add");
        return send_pasteDao.insert(send_paste);
    }

    @RequestMapping(value ="listByID",produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> listByID(Integer id){
        System.out.println("listByID");
        return send_pasteDao.listByID(id);
    }

    @RequestMapping("pinglun")
    public String pinglun(Model model){
        final List<Send_paste> send = send_pasteDao.selectAll();
        model.addAttribute("send",send);
        return "pinglun";
    }

    @RequestMapping("SendXQ")
    public String SendXQ(String spid,Model model){
        System.out.println("spid:"+spid);
        final List<Map<String, Object>> maps = send_pasteDao.SelSendAndBasicByid(spid);
        System.out.println("maps:"+maps.get(0));
        model.addAttribute("send",maps.get(0));
        return "SendXQ";
    }

    //查询回复信息
    @RequestMapping("SelBC")
    @ResponseBody
    public List<Map<String,Object>> SelBC(String spid){
        System.out.println("spid:"+spid);
        final List<Map<String, Object>> maps = send_pasteDao.SelComAndBasByid(spid);
        System.out.println("maps2:"+maps);
        return maps;
    }

    //添加回复
    @RequestMapping("AddCP")
    @ResponseBody
    public int AddCP(HttpServletRequest request, String con, Integer spid){
        System.out.println("con:"+con);
        System.out.println("spid:"+spid);
        String bmid="0";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName());
                if(cookie.getName().equals("bmid")){
                    bmid=cookie.getValue();
                }
            }
        }
        System.out.println("bmid:"+bmid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //获取当前时间
        final String thistime = df.format(new Date());
        System.out.println(thistime);// new Date()为获取当前系统时间

        final comment_paste comment_paste = new comment_paste();
        comment_paste.setContext(con);
        comment_paste.setSpid(spid);
        comment_paste.setBmid(Integer.valueOf(bmid));
        comment_paste.setCommention(thistime);

        System.out.println(comment_paste);
        final int insert = cp.insert(comment_paste);

        return insert;
    }

}

