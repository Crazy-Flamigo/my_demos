package com.jiahaowen.springboot_demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    private int id;
    private String name;

    @TableField(select = false)
    private String password;
    private String authority;

    @TableField(select = false)
    private String img;


}
