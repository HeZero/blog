package com.hsp.blog.service;

import java.util.List;

import com.hsp.base.Interface.BaseService;
import com.hsp.blog.pojo.Message;

public interface IMessageService extends BaseService<Message>{
	/**
	 * 查询最新发布的4条消息
	 * @return
	 */
	List<Message> getMessageNew(int size);
	
}
