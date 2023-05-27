package com.jiahaowen.springboot_demo.controller;


import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.domain.User;
import com.jiahaowen.springboot_demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iuserService;

    @PostMapping("/login")
    public R login(String name,String password){
        User user=  iuserService.login(name,password);
        return new R(user!=null , user);
    }


    @PostMapping("/signup")
    @ResponseBody
    public R signup(User user){

        return new R(iuserService.signup(user));

    }


    @GetMapping
    public R getByName(String name){
        User user=iuserService.getByName(name);
        return new R( user!=null,user);
    }



}
