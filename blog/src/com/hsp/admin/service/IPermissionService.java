package com.hsp.admin.service;

import com.hsp.admin.pojo.Permission;
import com.hsp.core.PageHelper;

/**
 * 权限接口
 * @author hsp
 *
 */
public interface IPermissionService {

	/**
	 * 新增权限
	 * @param permission
	 */
	void addPermission(Permission permission);
	/**
	 * 删除权限
	 * @param permissionId
	 */
	void deletePermission(String permissionId);
	/**
	 * 分页查询权限数据
	 * @param page
	 */
	void selectPermissionPagination(PageHelper<Permission> page);
	
}
