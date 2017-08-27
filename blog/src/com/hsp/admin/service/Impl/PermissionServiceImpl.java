package com.hsp.admin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.PermissionMapper;
import com.hsp.admin.pojo.Permission;
import com.hsp.admin.service.IPermissionService;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;

@Service
public class PermissionServiceImpl implements IPermissionService{
	
	@Autowired
	PermissionMapper pMapper;

	@Override
	public void addPermission(Permission permission) {
		pMapper.addPermission(permission);
	}

	@Override
	public void deletePermission(String permissionId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void selectPermissionPagination(PageHelper<Permission> page) {
			HMap params=page.getParams();
			page.generatePaginationParam();
			page.setList(pMapper.getPermissionList(params));
			page.setConut(pMapper.getPermissionListCount(params));
	}

	
}
