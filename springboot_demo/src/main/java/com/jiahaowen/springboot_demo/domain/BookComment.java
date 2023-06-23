package com.jiahaowen.springboot_demo.domain;

import lombok.Data;

@Data
public class BookComment {
    private int id;
    private int userid;
    private int bookid;
    private String commenthead;
    private String commentbody;
    private int likes;
    private int dislike;
    private String username;
}
