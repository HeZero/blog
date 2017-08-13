package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.RolePermissionLink;

public interface RolePermissionLinkMapper {

	void bindPermissions(List<RolePermissionLink> link);
	
	void unbindPermissions(List<RolePermissionLink> link);
	
}
