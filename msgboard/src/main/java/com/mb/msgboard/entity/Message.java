package com.mb.msgboard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("messages")
public class Message {
    @TableId(type = IdType.AUTO)
    private Long messageId;        // 留言ID，主键
    
    private Long userId;           // 用户ID，关联用户表
    
    private String title;          // 留言标题
    
    private String content;        // 留言内容
    
    private Integer status;        // 状态：0-删除，1-正常
    
    private Integer viewCount;     // 浏览次数
    
    private Integer likeCount;     // 点赞次数
    
    private Integer commentCount;  // 评论次数
    
    private LocalDateTime createdAt;    // 创建时间
    
    private LocalDateTime updatedAt;    // 更新时间
} 