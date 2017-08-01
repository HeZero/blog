package com.hsp.admin.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.AuthcMapper;
import com.hsp.admin.pojo.Authc;
import com.hsp.admin.service.IAuthcManager;

@Service
public class AuthcManager implements IAuthcManager{

	@Autowired
	AuthcMapper mapper;
	
	@Override
	public HashMap<String, String> getAuthcConfig() {
		List<Authc> list=mapper.getAuthcList();
		HashMap<String,String> map=new HashMap<String,String>();
		if(list!=null&&list.size()>0){
		  for(Authc chain:list){
			  map.put(chain.getChain(), chain.getDefenition());
		  }
		}
		return map;
	}

}
