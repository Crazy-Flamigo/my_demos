package com.jiahaowen.springboot_demo.service;

import com.jiahaowen.springboot_demo.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void TestGetbyID(){
        System.out.println(bookService.deleteByID(1));
    }

    @Test
    void TestUpdate(){
        System.out.println(bookService.deleteByID(1));
    }
}
