package com.hsp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsp.admin.pojo.Authc;
import com.hsp.admin.pojo.Permission;
import com.hsp.admin.pojo.Role;
import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IAuthcManager;
import com.hsp.admin.service.IPermissionService;
import com.hsp.admin.service.IRoleService;
import com.hsp.admin.service.IUserService;
import com.hsp.base.controller.BaseController;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;
import com.hsp.core.ZtreeNode;
@Controller
@RequestMapping(value="/admin/")
public class UserController extends BaseController{

	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IAuthcManager authcManager;
	
	@Autowired
	IPermissionService permissionService;
	
	/**
	 * 跳转用户查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String tolist(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/user_list";
	}
	/**
	 * 分页查询用户数据
	 * @param request
	 * @param respone
	 */
	@RequestMapping(value="/user/pagination",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void pagination(HttpServletRequest request,HttpServletResponse response){
		PageHelper<User> page=new PageHelper<>(request);
		List<User> list=userService.getUserListByParams(page.getParams());
		page.setConut(userService.getValueCountByParams(page.getParams()));
		page.setList(list);
		writeJsonData(response, page.getMapData());
	}
	/**
	 * 跳转新增用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/user/add",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAdd(HttpServletRequest request,HttpServletResponse response){
		HMap params=new HMap();
		List<Role> roleList=roleService.getRoleListByParams(params);
		request.setAttribute("roleList", roleList);
		return "/admin/user/user_add";
	}
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @param user
	 */
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void addUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user")User user,@RequestParam("roleId")String roleId){
		HMap result=new HMap();
		try {
			//TO DO
			userService.addValueInfo(user);
			userService.bindRoles(user.getUserId(), roleId);
			result.put("msg", "success");
		} catch (Exception e) {
			result.put("msg", "failed");
			e.printStackTrace();
		}finally{
			writeJsonData(response, result);
		}
	}
	/**
	 * 跳转角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/role/list",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toRole(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/role_list";
	}
	
	/**
	 * 跳转角色数据查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/role/pagination",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void rolePagination(HttpServletRequest request,HttpServletResponse response){
		PageHelper<Role> page=new PageHelper<>(request);
		roleService.selectRoleListPagination(page);
		writeJsonData(response, page.getMapData());
	}
	/**
	 * 跳转角色添加
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/role/add",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAddRole(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/role_add";
	}
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @param role
	 */
	@RequestMapping(value="/role/add",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void addRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("role")Role role){
		HMap result=new HMap();
		try {
			roleService.addRole(role);
			result.put("msg", "success");
		} catch (Exception e) {
			result.put("msg", "failed");
			e.printStackTrace();
		}finally{
			writeJsonData(response, result);
		}
	}
	/**
	 * 跳转安全配置
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/authc/list",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAuthc(HttpServletRequest request,HttpServletResponse response){
		return "admin/user/authc_list";
	}
	
	/**
	 * 获取安全配置数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/authc/pagination",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void authcPagination(HttpServletRequest request,HttpServletResponse response){
		PageHelper<Role> page=new PageHelper<>(request);
		authcManager.selectValueInfoPagination(page);
		writeJsonData(response, page.getMapData());
	}
	/**
	 * 跳转添加shiro安全配置
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/authc/add",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAddAuthc(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/authc_add";
	}
	/**
	 * 添加shiro安全配置
	 * @param request
	 * @param response
	 * @param config
	 */
	@RequestMapping(value="/authc/add",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void addAuthc(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("authc")Authc config){
		HMap result=new HMap();
		try {
			authcManager.addValueInfo(config);
			result.put("msg", "success");
		} catch (Exception e) {
			result.put("msg", "failed");
			e.printStackTrace();
		}finally{
			writeJsonData(response, result);
		}
	}
	/**
	 * 获取角色权限组
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/permission/data",method=RequestMethod.POST)
    @RequiresRoles("super")
	public void getPermissionData(HttpServletRequest request,HttpServletResponse response){
		List<ZtreeNode> tree=roleService.getRolePermissionGroup();
		writeJsonData(response, tree);
	}
	/**
	 * 跳转权限列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/permission/list",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toPermission(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/permission_list";
	}
	/**
	 * 获取权限列表数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/permission/pagination",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void getPermissionPagination(HttpServletRequest request,HttpServletResponse response){
		PageHelper<Permission> page=new PageHelper<>(request);
		permissionService.selectPermissionPagination(page);
		writeJsonData(response, page.getMapData());
	}
	/**
	 * 跳转新增权限
	 * @param request
	 * @param reponse
	 * @return
	 */
	@RequestMapping(value="/permission/add",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAddPermission(HttpServletRequest request,HttpServletResponse reponse){
		return "/admin/user/permission_add";
	}
	/**
	 * 新增权限
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/permission/add",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void addPermission(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("permission")Permission permission){
		HMap result=new HMap();
		try {
			permissionService.addPermission(permission);
			result.put("msg", "success");
		} catch (Exception e) {
			result.put("msg", "failed");
			e.printStackTrace();
		}finally{
			writeJsonData(response, result);
		}
	}
}
