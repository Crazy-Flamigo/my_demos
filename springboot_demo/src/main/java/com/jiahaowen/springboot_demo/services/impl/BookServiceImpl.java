package com.jiahaowen.springboot_demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.services.IBookService;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class BookServiceImpl implements IBookService {
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

    @Override
    public IPage<Book> getPage(int currentPage, int PageSize) {
        IPage page =new Page(currentPage, PageSize);
        bookDao.selectPage(page, null);
        return page;
    }


    //查找
    @Override
    public IPage<Book> getPage(int currentPage, int PageSize,String param) {
        LambdaQueryWrapper<Book> lqw =new LambdaQueryWrapper<Book>();
        lqw.like(!param.equals(""),Book::getName,param).or();
        lqw.like(!param.equals(""),Book::getAuthor,param).or();
        lqw.like(!param.equals(""),Book::getPublisher,param);

        IPage<Book> page =new Page<Book>(currentPage, PageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }

    @Override
    public List<Book> getFocus() {
        ArrayList<Integer> focusList = new ArrayList<Integer>();
        focusList.add(8);
        focusList.add(10);
        focusList.add(12);
        focusList.add(2);
        focusList.add(3);
        focusList.add(4);

        LambdaQueryWrapper<Book> lqw =new LambdaQueryWrapper<Book>();
        for (int i =0; i<focusList.size();i++){
            lqw.eq(Book::getId,focusList.get(i).intValue()).or();
        }
        return bookDao.selectList(lqw);
    }
}
