package com.hsp.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genesisdo.web.BaseController;
import com.hsp.admin.service.IUserService;

@Controller
@RequestMapping(value="/admin/")
public class LoginController extends BaseController{

	@Autowired
	IUserService userService;
	
	/**
	 * 后台管理首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response){
		return "/admin/index";
	}
	
}
