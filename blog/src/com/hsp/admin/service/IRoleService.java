package com.hsp.admin.service;

import java.util.List;

import com.hsp.admin.pojo.Role;
import com.hsp.core.PageHelper;
import com.hsp.core.ZtreeNode;

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
	 /**
	  * 分页查询角色数据
	  * @param page
	  */
	 void selectRoleListPagination(PageHelper<Role> page);
	 /**
	  * 获得角色权限组
	  * @return
	  */
	 List<ZtreeNode> getRolePermissionGroup();
}
