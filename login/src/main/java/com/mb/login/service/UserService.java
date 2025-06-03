package com.mb.login.service;

import com.mb.login.model.ResultCode;
import com.mb.login.model.User;

public interface UserService {
    public ResultCode login(User user);
    public ResultCode registry(User user);
}
