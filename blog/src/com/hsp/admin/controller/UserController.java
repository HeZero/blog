package com.hsp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IUserService;
import com.hsp.base.controller.BaseController;
import com.hsp.core.HMap;
@Controller
@RequestMapping(value="/admin/user")
public class UserController extends BaseController{

	@Autowired
	IUserService userService;
	
	/**
	 * 跳转用户查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String tolist(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/list";
	}
	/**
	 * 分页查询用户数据
	 * @param request
	 * @param respone
	 */
	@RequestMapping(value="pagination",method=RequestMethod.POST)
	@RequiresRoles("super")
	public void pagination(HttpServletRequest request,HttpServletResponse response){
		HMap params=new HMap(request);
		List<User> list=userService.getUserListByParams(params);
		params.put("list", list);
		params.put("code", 0);
		params.put("count", "57");
		params.put("msg", "");
		writeJsonData(response, params);
	}
	/**
	 * 跳转新增用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	@RequiresRoles("super")
	public String toAdd(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/add";
	}
	
}
