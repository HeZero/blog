package com.hsp.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.base.controller.BaseController;
import com.hsp.blog.service.IMessageService;
@Controller
@RequestMapping(value="/admin/message")
public class MessageController extends BaseController{

	@Autowired
	IMessageService msgService;
	
	/**
	 * 查询消息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,HttpServletResponse response){
		
		return "admin/message/list";
	}
	
	/**
	 * 跳转新增消息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(HttpServletRequest request,HttpServletResponse response){
		return "admin/message/add";
	}
	/**
	 * 新增消息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add/post",method=RequestMethod.POST)
	public String add(HttpServletRequest request,HttpServletResponse response){
		return "admin/message/list";
	}
	/**
	 * 获取分页数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/pagination",method=RequestMethod.GET)
	public void getPaginationData(HttpServletRequest request,HttpServletResponse response){
		
	}
}
