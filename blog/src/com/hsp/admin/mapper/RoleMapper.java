package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.Role;
import com.hsp.admin.pojo.UserRoleLink;
import com.hsp.core.HMap;

public interface RoleMapper {

	List<Role> getRoleListByParams(HMap params);
	
	List<Role> getRoleListByUsername(String username);
	
	void bindRoles(List<UserRoleLink> linkList);
}
