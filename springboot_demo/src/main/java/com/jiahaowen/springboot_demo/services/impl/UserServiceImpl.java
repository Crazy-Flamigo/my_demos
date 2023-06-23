package com.jiahaowen.springboot_demo.services.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiahaowen.springboot_demo.dao.UserDao;
import com.jiahaowen.springboot_demo.domain.User;
import com.jiahaowen.springboot_demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;


    @Override
    public User login(String name, String password) {
        LambdaQueryWrapper<User> lqw =new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,name).eq(User::getPassword,password);
        User user = userDao.selectOne(lqw);





        return user;
    }

    @Override
    public Boolean signup(User user) {
        String imgStr = user.getImg();
        user.setImg("1");
        userDao.insert(user);


        LambdaQueryWrapper<User> lqw =new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,user.getName()).eq(User::getPassword,user.getPassword());
        user = userDao.selectOne(lqw);



        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpg图片
            OutputStream out = new FileOutputStream("C:/webservice/myspringbootdemo/pic/user/"+user.getId()+".png");
            out.write(bytes);
            out.flush();
            out.close();


            return true;

        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
            return false;
        }
    }




    @Override
    public User getByName(String name) {
        LambdaQueryWrapper<User> lqw =new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,name);
        return userDao.selectOne(lqw);

    }


}
