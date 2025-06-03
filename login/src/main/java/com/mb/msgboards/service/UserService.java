package com.mb.msgboards.service;

import com.mb.msgboards.model.ResultCode;
import com.mb.msgboards.model.User;

public interface UserService {
    public ResultCode login(User user);
    public ResultCode registry(User user);
}
