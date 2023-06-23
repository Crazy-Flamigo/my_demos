package com.jiahaowen.springboot_demo.services;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiahaowen.springboot_demo.domain.BookComment;



public interface BookCommentService {
    Boolean addComment(int userid, int bookid,  String commenthead, String commentbody,String username);

    IPage<BookComment> getPage(int bookid, int currentPage, int PageSize);
}
