package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.Role;
import com.hsp.admin.pojo.UserRoleLink;
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
	 * 绑定角色
	 * @param linkList
	 */
	void bindRoles(List<UserRoleLink> linkList);
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
	
}
