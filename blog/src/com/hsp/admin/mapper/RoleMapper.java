package com.hsp.admin.mapper;

import java.util.List;
import java.util.Map;

import com.hsp.admin.pojo.Role;
import com.hsp.core.HMap;

public interface RoleMapper {
	
	/**
	 * 查询角色列表
	 * @param params
	 * @return
	 */
	List<Role> getRoleListByParams(HMap params);
	/**
	 * 通过用户名查询角色
	 * @param username
	 * @return
	 */
	List<Role> getRoleListByUsername(String username);
	/**
	 * 添加角色
	 * @param role
	 */
	void addRole(Role role);
	/**
	 * 查询角色数量
	 * @param params
	 * @return
	 */
	int getRoleListCountByParams(HMap params);
	/**
	 * 绑定权限
	 * @param params
	 */
	void bindPermission(Map<String, String> params);
	/**
	 * 解绑权限
	 * @param params
	 */
	void unbindPermission(Map<String, String> params);
	/**
	 * 解绑角色所有权限
	 * @param roleId
	 */
	void unbindPermissionById(String roleId);
	
}
