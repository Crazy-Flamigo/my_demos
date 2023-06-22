package com.jiahaowen.springboot_demo.controller;

import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.services.BookLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class BookLikeController {
    @Autowired
    BookLikeService bookLikeService;

    @GetMapping("/iflike")
    public R ifLike(int userid, int bookid){
        return new R(bookLikeService.checkIfLike(userid,bookid));
    }


    @GetMapping("/like")
    public R Like(int userid, int bookid){
        return new R(bookLikeService.like(userid,bookid));
    }


}
