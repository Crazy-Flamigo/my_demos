package com.jiahaowen.springboot_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//测试类找不到引导类解决办法：
//@SpringBootTest 改成 @SpringBootTest(classes = SpringbootDemoApplication.class)

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
