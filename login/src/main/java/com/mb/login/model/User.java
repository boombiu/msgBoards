package com.mb.login.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long userId;           // 用户 ID，主键
    private String username;          // 用户名
    private String gender;            // 性别
    private String birthday;          // 生日
    private String hobbit;            // 爱好
    private String password;          // 密码
    private String email;             // 邮箱
    private String phone;             // 手机号
    private String avatar;            // 头像url
    private Integer status;
    private LocalDateTime createdTime;   // 创建时间
    private LocalDateTime updatedTime;   // 更新时间
}
