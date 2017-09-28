package com.hsp.admin.service.Impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.RoleMapper;
import com.hsp.admin.mapper.UserMapper;
import com.hsp.admin.pojo.Role;
import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IUserService;
import com.hsp.base.enums.BaseStatus;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> getValueByParams(HMap params) {
		return userMapper.getUserListByParams(params);
	}

	@Override
	public User getValueById(String id) {
		HMap params=new HMap();
		params.put("userId", id);
		List<User> userList= userMapper.getUserListByParams(params);
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void updateValueInfo(User t) {
		userMapper.updateUser(t);
		
	}

	@Override
	public void addValueInfo(User t) {
		userMapper.addUser(t);
		
	}

	@Override
	public void deleteValueById(String id) {
		User user=this.getValueById(id);
		user.setIsUse(BaseStatus.NO);
		userMapper.updateUser(user);
		userMapper.unbindRoleById(user.getUserId());
	}

	@Override
	public int getValueCountByParams(HMap params) {
		return userMapper.getUserListCountByParams(params);
	}

	@Override
	public User getUserByUsername(String username) {
		HMap params=new HMap();
		params.put("username", username);
		List<User> userList=userMapper.getUserListByParams(params);
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void bindRoles(String userId, String roleIds) {
		if(roleIds!=null){
			Map<String,String> params=new HashMap<String,String>();
			params.put("userId", userId);
			String[] ids=roleIds.split(",");
			for(String id:ids){
				params.put("roleId", id);
				userMapper.bindRole(params);
				params.remove("roleId");
			}
		}
	}

	@Override
	public void unbindRoles(String userId, String roleIds) {
		if(roleIds!=null){
			Map<String,String> params=new HashMap<String,String>();
			params.put("userId", userId);
			String[] ids=roleIds.split(",");
			for(String id:ids){
				params.put("roleId", id);
				userMapper.unbindRole(params);
				params.remove("roleId");
			}
		}
	}

	@Override
	public Set<String> findRoles(String username) {
		List<Role> roleList=roleMapper.getRoleListByUsername(username);
		Set<String> set=new HashSet<>();
		if(roleList!=null&&roleList.size()>0){
			for(Role r:roleList){
				set.add(r.getRoleName());
			}
		}
		return set;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserListByParams(HMap params) {
		return userMapper.getUserListByParams(params);
	}

	@Override
	public void selectValueInfoPagination(PageHelper page) {
		page.generatePaginationParam();
		HMap params=page.getParams();
		page.setList(userMapper.getUserListByParams(params));
		page.setConut(userMapper.getUserListCountByParams(params));
	}

}
