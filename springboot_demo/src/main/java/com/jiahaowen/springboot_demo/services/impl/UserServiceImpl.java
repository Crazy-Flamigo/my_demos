package com.jiahaowen.springboot_demo.services.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiahaowen.springboot_demo.dao.UserDao;
import com.jiahaowen.springboot_demo.domain.User;
import com.jiahaowen.springboot_demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;


    @Override
    public User login(String name, String password) {
        LambdaQueryWrapper<User> lqw =new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,name).eq(User::getPassword,password);
        return userDao.selectOne(lqw);
    }

    @Override
    public Boolean signup(User user) {
        return userDao.insert(user)>0;
    }

    @Override
    public User getByName(String name) {
        LambdaQueryWrapper<User> lqw =new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,name);
        return userDao.selectOne(lqw);

    }


}
