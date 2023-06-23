package com.jiahaowen.springboot_demo.controller;

import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.services.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookcomment")
public class BookCommentController {
    @Autowired
    BookCommentService bookCommentService;


    @GetMapping( "/page={currentPage}/bookid={bookid}")
    public R getPage(@PathVariable int currentPage,@PathVariable int bookid){
        return new R(true,bookCommentService.getPage(bookid,currentPage,10));
    }
}
