package com.jiahaowen.springboot_demo.controller;


import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.domain.User;
import com.jiahaowen.springboot_demo.services.IUserService;
import com.sun.xml.internal.ws.encoding.ImageDataContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iuserService;

    @PostMapping("/login")
    public R login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        User user=  iuserService.login(name,password);

        //cookies
        Cookie cookie = new Cookie("name",name);
        cookie.setMaxAge(1209600);
        response.addCookie(cookie);
        cookie = new Cookie("password",password);
        cookie.setMaxAge(1209600);
        response.addCookie(cookie);

        return new R(user!=null , user);
    }


    @PostMapping("/autologin")
    public R Autologin(HttpServletRequest request, HttpServletResponse response){
        String name = "";
        String password = "";
        //cookies
        for(Cookie cookie: request.getCookies()){
            if(cookie.getName().equals("name")){
                name = cookie.getValue();
            }
            if(cookie.getName().equals("password")){
                password = cookie.getValue();
            }

        }

        User user=  iuserService.login(name,password);

        return new R(user!=null , user);
    }








    @PostMapping("/signup")
    @ResponseBody
    public R signup(User user, HttpServletRequest request, HttpServletResponse response){




        //cookies
        Cookie cookie = new Cookie("name",user.getName()) ;
        cookie.setMaxAge(1209600);
        response.addCookie(cookie);
        cookie = new Cookie("password",user.getPassword());
        cookie.setMaxAge(1209600);
        response.addCookie(cookie);



        return new R(iuserService.signup(user));

    }


    @GetMapping
    public R getByName(String name){
        User user=iuserService.getByName(name);
        return new R( user!=null,user);
    }




    @PostMapping("/logout")
    @ResponseBody
    public R logout(HttpServletRequest request, HttpServletResponse response){
        //cookies
        Cookie cookie = new Cookie("name","");
        response.addCookie(cookie);
        cookie = new Cookie("password","");
        response.addCookie(cookie);

        return new R(true);

    }




}
