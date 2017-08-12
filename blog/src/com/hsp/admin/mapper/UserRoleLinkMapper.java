package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.UserRoleLink;

public interface UserRoleLinkMapper {

	/**
	 * 绑定角色
	 * @param linkList
	 */
	void bindRoles(List<UserRoleLink> linkList);
	/**
	 * 解绑角色
	 * @param linkList
	 */
	void unbindRoles(List<UserRoleLink> linkList);
}
