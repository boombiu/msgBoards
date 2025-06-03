package com.mb.msgboard.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mb.msgboard.entity.Message;

public interface MessageService extends IService<Message> {
    /**
     * 分页查询留言列表
     * @param page 分页参数
     * @param keyword 搜索关键词
     * @return 分页结果
     */
    IPage<Message> getMessagePage(Page<Message> page, String keyword);

    /**
     * 创建留言
     * @param message 留言信息
     * @return 是否成功
     */
    boolean createMessage(Message message);

    /**
     * 更新留言
     * @param message 留言信息
     * @return 是否成功
     */
    boolean updateMessage(Message message);

    /**
     * 删除留言（逻辑删除）
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean deleteMessage(Long messageId);

    /**
     * 增加浏览次数
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean incrementViewCount(Long messageId);

    /**
     * 增加点赞次数
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean incrementLikeCount(Long messageId);

    /**
     * 减少点赞次数
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean decrementLikeCount(Long messageId);

    /**
     * 增加评论次数
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean incrementCommentCount(Long messageId);

    /**
     * 减少评论次数
     * @param messageId 留言ID
     * @return 是否成功
     */
    boolean decrementCommentCount(Long messageId);

    /**
     * 获取留言详情（同时增加浏览次数）
     * @param messageId 留言ID
     * @return 留言详情
     */
    Message getMessageDetail(Long messageId);
}
