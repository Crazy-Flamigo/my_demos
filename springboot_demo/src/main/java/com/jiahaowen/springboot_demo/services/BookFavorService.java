package com.jiahaowen.springboot_demo.services;


public interface BookFavorService {
     Boolean checkIfFavored(int userid,int bookid);
     Boolean favor(int userid,int bookid);


}
