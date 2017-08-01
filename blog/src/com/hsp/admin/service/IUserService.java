package com.hsp.admin.service;

import com.hsp.admin.pojo.User;
import com.hsp.base.Interface.BaseService;

public interface IUserService extends BaseService<User> {
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

}
