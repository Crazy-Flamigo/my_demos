package com.jiahaowen.springboot_demo.controller;

import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.services.BookReadedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readed")
public class BookReadedController {
    @Autowired
    BookReadedService bookReadedService;

    @GetMapping("/ifreaded")
    public R ifReaded(int userid, int bookid){
        return new R(bookReadedService.checkIfReaded(userid,bookid));
    }


    @GetMapping("/readed")
    public R Readed(int userid, int bookid){
        return new R(bookReadedService.readed(userid,bookid));
    }

}
