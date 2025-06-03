package com.mb.msgboards.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Login {
    private Integer loginId;          // 主键id
    private Integer userId;           // 操作用户id
    private String opration;          // 操作内容（登录，注册，修改等）
    private LocalDateTime oprTime;    // 创建时间
    private String oprIp;             // IP地址

}