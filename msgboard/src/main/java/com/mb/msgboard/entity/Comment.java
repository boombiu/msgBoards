package com.mb.msgboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("comments")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Long commentId;        // 评论ID，主键
    
    private Long messageId;        // 留言ID，关联留言表
    
    private Long userId;           // 用户ID，关联用户表
    
    private Long parentCommentId;  // 父评论ID，关联评论表，用于回复功能
    
    private String content;        // 评论内容
    
    private Integer status;        // 状态：0-删除，1-正常
    
    private Integer likeCount;     // 点赞次数
    
    private LocalDateTime createdAt;    // 创建时间
    
    private LocalDateTime updatedAt;    // 更新时间
} 