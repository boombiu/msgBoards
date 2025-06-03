package com.mb.msgboard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mb.msgboard.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    /**
     * 分页查询留言列表，包含用户信息
     * @param page 分页参数
     * @param keyword 搜索关键词
     * @return 分页结果
     */
    IPage<Message> selectMessagePage(Page<Message> page, @Param("keyword") String keyword);
    
    /**
     * 更新留言的浏览次数
     * @param messageId 留言ID
     * @return 影响行数
     */
    int updateViewCount(@Param("messageId") Long messageId);
    
    /**
     * 更新留言的点赞次数
     * @param messageId 留言ID
     * @param increment 增量（1或-1）
     * @return 影响行数
     */
    int updateLikeCount(@Param("messageId") Long messageId, @Param("increment") int increment);
    
    /**
     * 更新留言的评论次数
     * @param messageId 留言ID
     * @param increment 增量（1或-1）
     * @return 影响行数
     */
    int updateCommentCount(@Param("messageId") Long messageId, @Param("increment") int increment);
} 