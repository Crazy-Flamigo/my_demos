package com.jiahaowen.springboot_demo.services.impl;

import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Boolean save(Book book) {

        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean updateByID(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean deleteByID(int id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(int id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return  bookDao.selectList(null);
    }
}
