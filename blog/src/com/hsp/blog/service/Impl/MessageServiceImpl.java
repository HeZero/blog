package com.hsp.blog.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.blog.mapper.MessageMapper;
import com.hsp.blog.pojo.Message;
import com.hsp.blog.service.IMessageService;
import com.hsp.core.HMap;
@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private MessageMapper mapper;

	@Override
	public List<Message> getValueByParams(HMap params) {
		
		return mapper.getMessageListByParams(params);
	}

	@Override
	public int getValueCountByParams(HMap params) {
		
		return mapper.getMessageListCount(params);
	}

	@Override
	public Message getValueById(String id) {
		HMap params=new HMap();
		params.put("messageId", id);
		List<Message> list=mapper.getMessageListByParams(params);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void updateValueInfo(Message t) {
		mapper.updateMessage(t);
		
	}

	@Override
	public void addValueInfo(Message t) {
		t.setIsUse("1");
		mapper.addMessage(t);
	}

	@Override
	public void deleteValueById(String id) {
		mapper.deleteMessageById(id);
	}

	@Override
	public List<Message> getMessageNew(int size) {
		HMap params=new HMap();
		params.put("sort", "createTime");
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("start", 0);
		params.put("size", size);
		return mapper.getMessageListByParams(params);
	}
	
	

}
