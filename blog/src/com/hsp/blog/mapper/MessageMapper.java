package com.hsp.blog.mapper;

import java.util.List;

import com.hsp.blog.pojo.Message;
import com.hsp.core.HMap;

public interface MessageMapper {
	
	/**
	 * 通过参数查询消息
	 * @param params
	 * @return
	 */
    List<Message> getMessageListByParams(HMap params);
    
    /**
     * 查询总数
     * @param params
     * @return
     */
    int getMessageListCount(HMap params);
    
    /**
     * 更新消息
     * @param msg
     */
    void updateMessage(Message msg);
    
    /**
     * 物理删除消息
     * @param msgId
     */
    void deleteMessageById(String msgId);
    
    /**
     * 添加消息
     * @param msg
     */
    void addMessage(Message msg);
}