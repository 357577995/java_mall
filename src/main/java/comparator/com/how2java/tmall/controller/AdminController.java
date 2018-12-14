package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Admin;
import com.how2java.tmall.service.AdminService;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    AdminService AdminService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());

        List<Admin> us = AdminService.list();

        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listAdmin";
    }

    @RequestMapping("admin_user_add")
    public String add(Admin a) {
        AdminService.add(a);
        return "redirect:admin_user_list";
    }

    @RequestMapping("admin_login")
    public String login(String name, String password, String checks, Model model, HttpSession session) {

        String schecks = session.getAttribute("RANDOMVALIDATECODEKEY") .toString();
        if (!schecks.equals(checks)) {
            String msg = "验证码有误";
            model.addAttribute("msg", msg);
            return "admin/login";
        }
        Admin u = AdminService.get(name, password);
        if (u == null) {
            String msg = "帐户名或者密码错误";
            model.addAttribute("msg", msg);
            return "admin/login";
        }
        session.setAttribute("admin", u);
        return "redirect:admin_category_list";
    }
    /**
     * 登录页面生成验证码
     */
    @RequestMapping(value = "/admin_getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}