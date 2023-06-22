package com.jiahaowen.springboot_demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.dao.BookLikeDao;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.domain.BookLike;
import com.jiahaowen.springboot_demo.services.BookLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLikeServiceImpl implements BookLikeService {


    @Autowired
    BookLikeDao bookLikeDao;
    @Autowired
    BookDao bookDao;


    @Override
    public Boolean checkIfLike(int userid, int bookid) {
        LambdaQueryWrapper<BookLike> lqw =new LambdaQueryWrapper<BookLike>();
        lqw.eq(BookLike::getUserid,userid).eq(BookLike::getBookid,bookid);
        return bookLikeDao.selectOne(lqw)!=null;
    }

    @Override
    public Boolean like(int userid, int bookid) {
        LambdaQueryWrapper<BookLike> lqw =new LambdaQueryWrapper<BookLike>();
        lqw.eq(BookLike::getUserid,userid).eq(BookLike::getBookid,bookid);
        if(bookLikeDao.selectOne(lqw)!=null){
            bookLikeDao.delete(lqw);
            Book book= bookDao.selectById(bookid);
            book.setLikes(book.getLikes()-1);
            bookDao.updateById(book);
            return false;
        }
        else {
            BookLike bookLike =new BookLike();
            bookLike.setBookid(bookid);
            bookLike.setUserid(userid);
            bookLikeDao.insert(bookLike);
            Book book= bookDao.selectById(bookid);
            book.setLikes(book.getLikes()+1);
            bookDao.updateById(book);
            return true;
        }
    }
}
