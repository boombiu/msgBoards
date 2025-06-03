package com.mb.login.service.impl;

import com.mb.login.mapper.LoginMapper;
import com.mb.login.mapper.UserMapper;
import com.mb.login.model.Login;
import com.mb.login.model.ResultCode;
import com.mb.login.model.User;
import com.mb.login.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public ResultCode login(User user) {
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser == null) {
            return new ResultCode(400, "用户名不存在");
        }
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return new ResultCode(400, "密码错误");
        }
        // 记录登录日志
        Login login = new Login();
        login.setUserId(existingUser.getUserId());
        login.setOpration("登录");
        login.setOprIp(getClientIp(request)); // 获取实际IP地址
        loginMapper.insert(login);
        return new ResultCode(200, "登录成功");
    }

    @Override
    public ResultCode registry(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            return new ResultCode(400, "用户名已存在");
        }
        if (userMapper.findByEmail(user.getEmail()) != null) {
            return new ResultCode(400, "邮箱已存在");
        }
        
        // 生成8位随机user_id
        String userId = generateUserId();
        // 确保生成的userId不重复
        while (userMapper.findByUserId(userId) != null) {
            userId = generateUserId();
        }
        user.setUserId(Integer.getInteger(userId));
        
        userMapper.insert(user);
        // 记录注册日志
        Login login = new Login();
        login.setUserId(user.getUserId());
        login.setOpration("注册");
        login.setOprIp(getClientIp(request)); // 获取实际IP地址
        loginMapper.insert(login);
        return new ResultCode(200, "注册成功");
    }

    /**
     * 生成8位随机user_id
     * 包含数字和大写字母
     */
    private String generateUserId() {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder userId = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            userId.append(characters.charAt(index));
        }
        
        return userId.toString();
    }

    // 获取客户端IP地址
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
} 