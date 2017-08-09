package com.hsp.admin.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.base.controller.BaseController;
import com.hsp.blog.pojo.Message;
import com.hsp.blog.service.IMessageService;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;
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
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("msg")Message msg){
		msgService.addValueInfo(msg);
		return "admin/message/list";
	}
	/**
	 * 获取分页数据
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/pagination",method=RequestMethod.POST)
	public void getPaginationData(HttpServletRequest request,HttpServletResponse response){
		PageHelper<Message> page=new PageHelper<>(request);
		msgService.selectValueInfoPagination(page);
		writeJsonData(response, page.getMapData());
	}
	/**
	 * 跳转修改消息
	 * @param messageId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/edit/{messageId}",method=RequestMethod.GET)
	public String toEdit(@PathVariable("messageId")String messageId,HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("msg", msgService.getValueById(messageId));
		return "/admin/message/edit";
	}
	/**
	 * 修改消息
	 * @param msg
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute("message")Message msg,HttpServletRequest request,HttpServletResponse response){
		msgService.updateValueInfo(msg);
		return "/admin/message/list";
	}
	/**
	 * 删除消息
	 * @param messageId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/delete/{messageId}",method=RequestMethod.GET)
	public String delete(@PathVariable("messageId") String messageId,HttpServletRequest request,HttpServletResponse response){
		msgService.deleteValueById(messageId);
		return "redirect:/list";
	}
}
