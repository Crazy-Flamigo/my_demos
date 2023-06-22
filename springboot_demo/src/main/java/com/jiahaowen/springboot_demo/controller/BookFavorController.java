package com.jiahaowen.springboot_demo.controller;

import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.services.BookFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favor")
public class BookFavorController {
    @Autowired
    BookFavorService bookFavorService;

    @GetMapping("/iffavor")
    public R ifFavor(int userid, int bookid){
        return new R(bookFavorService.checkIfFavored(userid,bookid));
    }


    @GetMapping("/favor")
    public R favor(int userid, int bookid){
        return new R(bookFavorService.favor(userid,bookid));
    }





}
