package com.jiahaowen.springboot_demo.service;

import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.services.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService IBookService;



    @Test
    void TestSave(){

        Book book = new Book();
        book.setName("果壳中的宇宙");
        book.setAuthor("史蒂芬·霍金");
        book.setPublisher("湖南科学技术出版社");
        book.setDescription("这是一本研究宇宙和量子力学的书，史蒂芬霍金自《时间简史》以来最重要的著作");
        book.setCategory("科技");
        System.out.println(IBookService.save(book));
    }

    @Test
    void TestUpdate(){

        Book book = new Book();
        book.setId(2);
        book.setCategory("科技");
        System.out.println(IBookService.updateByID(book));
    }


    @Test
    void TestGetbyID(){
        System.out.println(IBookService.getById(1));
    }

    @Test
    void TestGetAll(){
        System.out.println(IBookService.getAll());
    }

    @Test
    void TestDelet(){
        System.out.println(IBookService.getAll());
    }
}
