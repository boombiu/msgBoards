package com.mb.msgboards.mapper;

import com.mb.msgboards.model.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    void insert(Login login);
} 