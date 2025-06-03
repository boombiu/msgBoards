package com.mb.login.mapper;

import com.mb.login.model.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    void insert(Login login);
} 