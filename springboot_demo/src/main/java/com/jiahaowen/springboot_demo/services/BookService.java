package com.jiahaowen.springboot_demo.services;

import com.jiahaowen.springboot_demo.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean updateByID(Book book);
    Boolean deleteByID(int id);
    Book getById(int id);
    List<Book> getAll();

}
