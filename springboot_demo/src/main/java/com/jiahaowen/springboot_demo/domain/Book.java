package com.jiahaowen.springboot_demo.domain;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private String category;
    private String language;
    private String description;
    private int readeds;
    private int favors;
    private int likes;
    private int comments;
}
