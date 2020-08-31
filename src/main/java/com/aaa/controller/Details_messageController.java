package com.aaa.controller;

import com.aaa.dao.Details_messageDao;
import com.aaa.entity.Details_message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Details_message")
public class Details_messageController {
    @Resource
    Details_messageDao dm;

    //根据cookie中Id查询详细信息
    @RequestMapping("SelDetails")
    public String SelDetails(HttpServletRequest request, Model model){
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
        final List<Details_message> details_messages;
        System.out.println(!bmid.equals("0"));
        if(!bmid.equals("0")) {
            details_messages = dm.SelbyBmid(bmid);
        }else {details_messages=null;}
        model.addAttribute("Dlist",details_messages.get(0));
        return "details";
    }
    //修改个人详细信息
    @RequestMapping("UpdDetails")
    public String UpdDetails(Details_message det) {
        System.out.println("修改详细信息get");
        System.out.println(det);
        final int i = dm.updateByPrimaryKey(det);
        if(i>0){System.out.println("UpdateYes");}
        return "redirect:/basic_message/GeRen";
    }
}
