package com.jiahaowen.springboot_demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiahaowen.springboot_demo.dao.BookCommentDao;
import com.jiahaowen.springboot_demo.dao.BookDao;
import com.jiahaowen.springboot_demo.domain.Book;
import com.jiahaowen.springboot_demo.domain.BookComment;
import com.jiahaowen.springboot_demo.services.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCommentServiceImpl implements BookCommentService {
    @Autowired
    BookCommentDao bookCommentDao;
    @Autowired
    BookDao bookDao;



    @Override
    public Boolean addComment(int userid, int bookid, String commenthead, String commentbody,String username) {
        BookComment bookComment = new BookComment();
        bookComment.setBookid(bookid);
        bookComment.setCommentbody(commentbody);
        bookComment.setCommenthead(commenthead);
        bookComment.setUserid(userid);
        bookComment.setUsername(username);
        Book book= bookDao.selectById(bookid);
        book.setComments(book.getComments()+1);
        bookDao.updateById(book);
        return bookCommentDao.insert(bookComment)>0;
    }

    @Override
    public IPage<BookComment> getPage(int bookid, int currentPage, int PageSize) {
        LambdaQueryWrapper<BookComment> lqw =new LambdaQueryWrapper<BookComment>();
        lqw.eq(BookComment::getBookid,bookid);
        IPage page =new Page(currentPage, PageSize);
        bookCommentDao.selectPage(page, lqw);
        return page;
    }
}
