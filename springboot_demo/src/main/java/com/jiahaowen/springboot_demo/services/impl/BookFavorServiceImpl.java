package com.jiahaowen.springboot_demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.dao.BookFavorDao;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.domain.BookFavor;
import com.jiahaowen.springboot_demo.services.BookFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookFavorServiceImpl implements BookFavorService {

    @Autowired
    BookFavorDao bookFavorDao;
    @Autowired
    BookDao bookDao;


    @Override
    public Boolean checkIfFavored(int userid, int bookid) {
        LambdaQueryWrapper<BookFavor> lqw =new LambdaQueryWrapper<BookFavor>();
        lqw.eq(BookFavor::getUserid,userid).eq(BookFavor::getBookid,bookid);
        return bookFavorDao.selectOne(lqw)!=null;
    }


    @Override
    public Boolean favor(int userid, int bookid) {
        LambdaQueryWrapper<BookFavor> lqw =new LambdaQueryWrapper<BookFavor>();
        lqw.eq(BookFavor::getUserid,userid).eq(BookFavor::getBookid,bookid);
        if(bookFavorDao.selectOne(lqw)!=null){
            bookFavorDao.delete(lqw);
            Book book= bookDao.selectById(bookid);
            book.setFavors(book.getFavors()-1);
            bookDao.updateById(book);
            return false;
        }
        else {
            BookFavor bookFavor =new BookFavor();
            bookFavor.setBookid(bookid);
            bookFavor.setUserid(userid);
            bookFavorDao.insert(bookFavor);
            Book book= bookDao.selectById(bookid);
            book.setFavors(book.getFavors()+1);
            bookDao.updateById(book);
            return true;
        }
    }

}
