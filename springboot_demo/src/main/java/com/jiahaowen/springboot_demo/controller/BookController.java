package com.jiahaowen.springboot_demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiahaowen.springboot_demo.controller.utils.R;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateByID(book));
    }

    @DeleteMapping("{id}")
    public  R delete(@PathVariable int id){
        return new R(bookService.deleteByID(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true,bookService.getAll());
    }

    @GetMapping( "{id}")
    public R getByID(@PathVariable int id){
        return new R(true,bookService.getById(id));
    }


//    @GetMapping( "/page={currentPage}")
//    public R getPage(@PathVariable int currentPage){
//        return new R(true,bookService.getPage(currentPage,8));
//    }

    //发送请求时使用 '?' + 键值对，可以直接把参数传过来
    @GetMapping( "/page={currentPage}")
    public R getPage(@PathVariable int currentPage,String param){

        return new R(true,bookService.getPage(currentPage,8,param));
    }

    @GetMapping( "/focus")
    public R getFocus(){

        return new R(true,bookService.getFocus());
    }
}
