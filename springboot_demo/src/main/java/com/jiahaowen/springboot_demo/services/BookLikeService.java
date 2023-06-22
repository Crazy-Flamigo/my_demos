package com.jiahaowen.springboot_demo.services;

import org.springframework.stereotype.Service;


public interface BookLikeService {
    Boolean checkIfLike(int userid,int bookid);
    Boolean like(int userid,int bookid);
}
