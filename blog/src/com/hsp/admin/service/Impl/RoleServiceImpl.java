package com.hsp.admin.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.PermissionMapper;
import com.hsp.admin.mapper.RoleMapper;
import com.hsp.admin.pojo.Permission;
import com.hsp.admin.pojo.Role;
import com.hsp.admin.service.IRoleService;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;
import com.hsp.core.ZtreeNode;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	PermissionMapper pMapper;
	
	@Override
	public void addRole(Role role) {
		roleMapper.addRole(role);
		
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
		page.setList(roleMapper.getRoleListByParams(page.getParams()));
		page.setConut(roleMapper.getRoleListCountByParams(page.getParams()));
	}

	@Override
	public List<ZtreeNode> getRolePermissionGroup() {
		HMap params=new HMap();
		List<Role> roleList=roleMapper.getRoleListByParams(params);
		List<ZtreeNode> ztree=new ArrayList<>();
		if(roleList!=null){
			for(Role role:roleList){
				ZtreeNode node=new ZtreeNode();
				node.setId(role.getRoleId());
				node.setName(role.getDescription());
				List<ZtreeNode> childList=new ArrayList<>();
				List<Permission> pList=pMapper.getPermissionByRole(role.getRoleId());
				if(pList!=null){
					for(Permission p:pList){
						ZtreeNode child=new ZtreeNode();
						child.setId(p.getpId().toString());
						child.setName(p.getName());
						childList.add(child);
					}
				}
				node.setChildren(childList);
				ztree.add(node);
			}
		}
		return ztree;
	}

	@Override
	public List<Role> getRoleListByParams(HMap params) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleListByParams(params);
	}

}
