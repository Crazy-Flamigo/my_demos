package com.jiahaowen.springboot_demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {


    private String name;

    @TableField(select = false)
    private String password;
    private String authority;


}
