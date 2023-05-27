package com.jiahaowen.springboot_demo.services;

import com.jiahaowen.springboot_demo.domain.User;

public interface IUserService {

    public User login(String name,String password);

    public Boolean signup(User user);

    public User getByName(String name);

}
