package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.User;
import com.hsp.core.HMap;

public interface UserMapper {

	void addUser(User user);
	
	void updateUser(User user);
	
	List<User> getUserListByParams(HMap params);
	
	int getUserListCountByParams(HMap params);
}
