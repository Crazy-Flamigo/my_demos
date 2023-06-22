package com.jiahaowen.springboot_demo.services;

public interface BookReadedService {
    Boolean checkIfReaded(int userid,int bookid);
    Boolean readed(int userid,int bookid);
}
