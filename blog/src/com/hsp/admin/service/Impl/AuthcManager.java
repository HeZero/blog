package com.hsp.admin.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.AuthcMapper;
import com.hsp.admin.pojo.Authc;
import com.hsp.admin.service.IAuthcManager;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;

@Service
public class AuthcManager implements IAuthcManager{

	@Autowired
	AuthcMapper mapper;
	
	@Override
	public HashMap<String, String> getAuthcConfig() {
		List<Authc> list=mapper.getAuthcList();
		HashMap<String,String> map=new HashMap<>();
		if(list!=null&&list.size()>0){
			for(Authc authc:list){
				map.put(authc.getChain(),authc.getDefenition());
			}
		}
		return map;
	}

	@Override
	public List<Authc> getValueByParams(HMap params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getValueCountByParams(HMap params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Authc getValueById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateValueInfo(Authc t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addValueInfo(Authc t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteValueById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectValueInfoPagination(PageHelper page) {
		page.generatePaginationParam();
		page.setList(mapper.getAuthcListByParams(page.getParams()));
		page.setConut(mapper.getAuthcListCountByParams(page.getParams()));
		
	}

}
