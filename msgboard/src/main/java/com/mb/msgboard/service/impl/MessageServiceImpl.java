package com.mb.msgboard.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mb.msgboard.entity.Message;
import com.mb.msgboard.mapper.MessageMapper;
import com.mb.msgboard.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public IPage<Message> getMessagePage(Page<Message> page, String keyword) {
        return baseMapper.selectMessagePage(page, keyword);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createMessage(Message message) {
        // 设置初始值
        message.setViewCount(0);
        message.setLikeCount(0);
        message.setCommentCount(0);
        message.setStatus(1);
        return save(message);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMessage(Message message) {
        // 只允许更新标题和内容
        Message updateMessage = new Message();
        updateMessage.setMessageId(message.getMessageId());
        updateMessage.setTitle(message.getTitle());
        updateMessage.setContent(message.getContent());
        return updateById(updateMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteMessage(Long messageId) {
        // 逻辑删除
        Message message = new Message();
        message.setMessageId(messageId);
        message.setStatus(0);
        return updateById(message);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean incrementViewCount(Long messageId) {
        return baseMapper.updateViewCount(messageId) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean incrementLikeCount(Long messageId) {
        return baseMapper.updateLikeCount(messageId, 1) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean decrementLikeCount(Long messageId) {
        return baseMapper.updateLikeCount(messageId, -1) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean incrementCommentCount(Long messageId) {
        return baseMapper.updateCommentCount(messageId, 1) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean decrementCommentCount(Long messageId) {
        return baseMapper.updateCommentCount(messageId, -1) > 0;
    }

    @Override
    public Message getMessageDetail(Long messageId) {
        // 增加浏览次数
        incrementViewCount(messageId);
        // 获取留言详情
        return getById(messageId);
    }
} 