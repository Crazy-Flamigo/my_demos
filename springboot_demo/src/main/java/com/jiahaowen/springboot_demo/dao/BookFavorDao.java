package com.jiahaowen.springboot_demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiahaowen.springboot_demo.domain.BookFavor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookFavorDao extends BaseMapper<BookFavor> {
}
