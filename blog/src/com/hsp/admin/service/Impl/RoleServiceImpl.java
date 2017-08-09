package com.hsp.admin.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.RoleMapper;
import com.hsp.admin.pojo.Role;
import com.hsp.admin.service.IRoleService;
import com.hsp.core.PageHelper;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleMapper mapper;
	
	@Override
	public void addRole(Role role) {
		mapper.addRole(role);
		
	}

	@Override
	public void deleteRole(String roleId) {
		
		
	}

	@Override
	public void bindPermisssions(String roleId, String permissionIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbindPermissions(String roleId, String premissionIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectRoleListPagination(PageHelper<Role> page) {
		page.generatePaginationParam();
		page.setList(mapper.getRoleListByParams(page.getParams()));
		page.setConut(mapper.getRoleListCountByParams(page.getParams()));
	}

}
