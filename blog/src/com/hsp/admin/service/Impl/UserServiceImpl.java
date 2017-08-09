package com.hsp.admin.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.admin.mapper.RoleMapper;
import com.hsp.admin.mapper.UserMapper;
import com.hsp.admin.pojo.Role;
import com.hsp.admin.pojo.User;
import com.hsp.admin.pojo.UserRoleLink;
import com.hsp.admin.service.IUserService;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateValueInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addValueInfo(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteValueById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValueCountByParams(HMap params) {
		// TODO Auto-generated method stub
		return 0;
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
			List<UserRoleLink> list=new ArrayList<>();
			String[] Ids=roleIds.split(",");
			for(int i=0;i<Ids.length;i++){
				UserRoleLink link=new UserRoleLink();
				link.setUserId(userId);
				link.setRoleId(Ids[i]);
				list.add(link);
			}
			roleMapper.bindRoles(list);
		}
	}

	@Override
	public void unbindRoles(String userId, String roleIds) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
