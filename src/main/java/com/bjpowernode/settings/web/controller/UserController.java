package com.bjpowernode.settings.web.controller;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.domain.User;
import com.bjpowernode.settings.service.UserService;
import com.bjpowernode.settings.service.impl.UserServiceImpl;
import com.bjpowernode.utils.MD5Util;
import com.bjpowernode.utils.PrintJson;
import com.bjpowernode.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet  {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("用户进入控制器");
        String path = request.getServletPath();

        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response){
        //获得账号密码ip
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{
            User user = us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e){
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }
    }
}
