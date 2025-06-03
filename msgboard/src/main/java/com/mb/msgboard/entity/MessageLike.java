package com.mb.msgboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("message_likes")
public class MessageLike {
    @TableId(type = IdType.AUTO)
    private Long likeId;           // 点赞ID，主键
    
    private Long messageId;        // 留言ID，关联留言表
    
    private Long userId;           // 用户ID，关联用户表
    
    private LocalDateTime createdAt;    // 创建时间
} 