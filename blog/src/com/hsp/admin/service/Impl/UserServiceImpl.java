package com.hsp.admin.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.UserMapper;
import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IUserService;
import com.hsp.core.HMap;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> getValueByParams(HMap params) {
		return userMapper.getUserListByParams(params);
	}

	@Override
	public User getValueById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateValueInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addValueInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteValueById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValueCountByParams(HMap params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserByUsername(String username) {
		HMap params=new HMap();
		params.put("username", username);
		List<User> userList=userMapper.getUserListByParams(params);
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}

}
