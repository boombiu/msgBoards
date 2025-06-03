package com.mb.login.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("login")
public class Login {
    @TableId(type = IdType.AUTO)
    private Long loginId;          // 主键id
    private Integer userId;           // 操作用户id
    private String opration;          // 操作内容（登录，注册，修改等）
    private LocalDateTime oprTime;    // 创建时间
    private String oprIp;             // IP地址

}