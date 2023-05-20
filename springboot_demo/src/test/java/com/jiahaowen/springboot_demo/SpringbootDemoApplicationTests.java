package com.jiahaowen.springboot_demo;

import com.jiahaowen.springboot_demo.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//测试类找不到引导类解决办法：
//@SpringBootTest 改成 @SpringBootTest(classes = SpringbootDemoApplication.class)

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void daoTest(){
        System.out.println(bookDao.selectById(1));
    }
}
