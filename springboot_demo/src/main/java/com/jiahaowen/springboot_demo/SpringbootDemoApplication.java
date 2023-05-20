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

    /*//解析引导类功能
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootDemoApplication.class, args);
        Object bean = ctx.getBean(SpringbootDemoApplication.class);
        System.out.println("Bean info =======>"+bean);
    }
    */
}
