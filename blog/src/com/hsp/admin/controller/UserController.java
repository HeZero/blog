package com.hsp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsp.admin.service.IUserService;
import com.hsp.base.controller.BaseController;
@Controller
@RequestMapping(value="/admin/")
public class UserController extends BaseController{

	@Autowired
	IUserService userService;
}
