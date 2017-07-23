package com.hsp.admin.service;

import com.hsp.admin.pojo.Role;

/**
 * 角色绑定接口
 * @author hsp
 *
 */
public interface IRoleService {
		
	/**
	 * 添加角色
	 * @param role
	 */
	 void addRole(Role role);
	/**
	 * 删除角色
	 * @param roleId
	 */
	 void deleteRole(String roleId);
	 /**
	  * 绑定权限
	  * @param roleId
	  * @param permissionIds
	  */
	 void bindPermisssions(String roleId,String permissionIds);
	 /**
	  * 解绑权限
	  * @param roleId
	  * @param premissionIds
	  */
	 void unbindPermissions(String roleId,String premissionIds);
}
