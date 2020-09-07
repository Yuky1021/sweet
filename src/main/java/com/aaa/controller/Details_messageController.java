package com.aaa.controller;

import com.aaa.dao.Details_messageDao;
import com.aaa.entity.Details_message;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@CrossOrigin
@Controller
@RequestMapping("Details_message")
public class Details_messageController {
    @Resource
    Details_messageDao dm;

    @RequestMapping(value ="findAll",produces = "application/json")
    @ResponseBody
    public PageHelpers<Map<String,Object>> findAll(PageHelpers<Map<String,Object>> ph){
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Map<String,Object>> details_messages = dm.findAll();
        ph.setRows(details_messages);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(details_messages);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(dm.totalCount());
        System.out.println("totalCount:"+dm.totalCount());
        return ph;
    }

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
    //修改个人详细信息(文件上传)
    @RequestMapping("UpdDetails")
    public String UpdDetails(Details_message det,@RequestParam("file") MultipartFile file,String filesrc){

        System.out.println("进入上传");
        // 判断是否为空文件
        if (!file.isEmpty()) {
            // 文件类型
            String contentType = file.getContentType();
            // springmvc处理后的文件名
            String fileName = file.getName();
            // 重命名上传的文件名
            String origFileName = new Date().getTime() + ".jpg";
            System.out.println("origFileName:  " + "/sweet/path/"+origFileName);
            // 文件大小
            Long fileSize = file.getSize();
            det.setPic("/sweet/path/"+origFileName);

            // 保存文件
            // 这里直接使用transferTo
            try {
                file.transferTo(new File("d://image//" + origFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            det.setPic(filesrc);
        }


        System.out.println("修改详细信息get");
        System.out.println(det);
        final int i = dm.updateByPrimaryKey(det);
        System.out.println("i: "+i);
        if(i>0){System.out.println("UpdateYes");}
        return "redirect:SelDetails";
    }
}