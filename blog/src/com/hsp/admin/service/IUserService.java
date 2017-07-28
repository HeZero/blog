package com.hsp.admin.service;

import java.util.List;
import java.util.Set;

import com.hsp.admin.pojo.User;
import com.hsp.base.Interface.BaseService;
import com.hsp.core.HMap;

public interface IUserService extends BaseService<User> {
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	/**
	 * 绑定角色
	 * @param userId
	 * @param roleIds
	 */
	void bindRoles(String userId,String roleIds);
	/**
	 * 解绑角色
	 * @param userId
	 * @param roleIds
	 */
	void unbindRoles(String userId,String roleIds);
	/**
	 * 查询用户所有角色
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);
	/**
	 * 查询用户所有权限
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);
	/**
	 * 查询用户列表
	 * @param params
	 * @return
	 */
	List<User> getUserListByParams(HMap params);

}
