package com.mb.msgboards.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;           // 用户 ID，主键
    private String username;          // 用户名
    private String gender;            // 性别
    private String birthday;          // 生日
    private String hobbit;            // 爱好
    private String password;          // 密码
    private String email;             // 邮箱
    private String phone;             // 手机号
    private String avatar;            // 头像url
    private java.time.LocalDateTime createdTime;   // 创建时间
    private java.time.LocalDateTime updatedTime;   // 更新时间
}
