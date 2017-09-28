package com.hsp.admin.mapper;

import java.util.List;
import java.util.Map;

import com.hsp.admin.pojo.User;
import com.hsp.core.HMap;

public interface UserMapper {

	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过参数查询用户
	 * @param params
	 * @return
	 */
	List<User> getUserListByParams(HMap params);
	/**
	 * 查询总数
	 * @param params
	 * @return
	 */
	int getUserListCountByParams(HMap params);
	/**
	 * 绑定角色
	 * @param params
	 */
	void bindRole(Map<String,String> params);
	/**
	 * 解绑角色
	 * @param params
	 */
	void unbindRole(Map<String,String> params);
	/**
	 * 解绑用户所有角色
	 * @param userId
	 */
	void unbindRoleById(String userId);
}
