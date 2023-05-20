package com.jiahaowen.springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//Springboot引导类
//整个程序的入口
//作用：加载Bean
@SpringBootApplication
public class SpringbootDemoApplication {
    //自动创建出来的长这个样子：
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
