package com.jiahaowen.springboot_demo.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiahaowen.springboot_demo.domain.Book;

import java.util.List;

public interface IBookService {
    Boolean save(Book book);
    Boolean updateByID(Book book);
    Boolean deleteByID(int id);
    Book getById(int id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int PageSize);


    IPage<Book> getPage(int currentPage, int i, String param);

    List<Book> getFocus();
}
