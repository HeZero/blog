package com.hsp.admin.service.Impl;

import com.hsp.admin.pojo.Permission;

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
	
}
