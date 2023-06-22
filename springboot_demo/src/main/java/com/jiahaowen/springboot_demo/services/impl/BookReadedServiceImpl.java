package com.jiahaowen.springboot_demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.dao.BookReadedDao;
import com.jiahaowen.springboot_demo.domain.Book;


import com.jiahaowen.springboot_demo.domain.BookReaded;
import com.jiahaowen.springboot_demo.services.BookReadedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReadedServiceImpl implements BookReadedService {

    @Autowired
    BookReadedDao bookReadedDao;
    @Autowired
    BookDao bookDao;

    @Override
    public Boolean checkIfReaded(int userid, int bookid) {
        LambdaQueryWrapper<BookReaded> lqw =new LambdaQueryWrapper<BookReaded>();
        lqw.eq(BookReaded::getUserid,userid).eq(BookReaded::getBookid,bookid);
        return bookReadedDao.selectOne(lqw)!=null;
    }

    @Override
    public Boolean readed(int userid, int bookid) {
        LambdaQueryWrapper<BookReaded> lqw =new LambdaQueryWrapper<BookReaded>();
        lqw.eq(BookReaded::getUserid,userid).eq(BookReaded::getBookid,bookid);
        if(bookReadedDao.selectOne(lqw)!=null){
            bookReadedDao.delete(lqw);
            Book book= bookDao.selectById(bookid);
            book.setReadeds(book.getReadeds()-1);
            bookDao.updateById(book);
            return false;
        }
        else {
            BookReaded bookReaded =new BookReaded();
            bookReaded.setBookid(bookid);
            bookReaded.setUserid(userid);
            bookReadedDao.insert(bookReaded);
            Book book= bookDao.selectById(bookid);
            book.setReadeds(book.getReadeds()+1);
            bookDao.updateById(book);
            return true;
        }
    }
}
