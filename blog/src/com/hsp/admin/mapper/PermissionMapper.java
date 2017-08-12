package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.Permission;
import com.hsp.core.HMap;

public interface PermissionMapper {
	/**
	 * 添加权限
	 * @param permission
	 */
	void addPermission(Permission permission);
	
	void updatePermission(Permission permission);
	
	List<Permission> getPermissionList(HMap params);
	
	int getPermissionListCount(HMap params);

}
