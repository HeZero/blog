package com.hsp.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.admin.service.IUserService;
import com.hsp.base.controller.BaseController;
import com.hsp.blog.service.IArticleService;
import com.hsp.blog.service.IMessageService;

@Controller
public class ClientController extends BaseController{

	@Autowired
	IMessageService msgService;
	
	@Autowired
	IArticleService articleService;
	
	@Autowired
	IUserService userService;

	/**
	 * 跳转首页
	 * @param response
	 * @param request
	 */
	@RequestMapping(value={"index","/"},method=RequestMethod.GET)
	public String toIndex(HttpServletResponse response,HttpServletRequest request) {
		request.setAttribute("user", userService.getUserByUsername("hsp"));
		request.setAttribute("msgList",msgService.getMessageNew(4));
		request.setAttribute("articleList", articleService.getArticleNew(8));
		request.setAttribute("hot", articleService.getArticleHot(8));
		request.setAttribute("recent", articleService.getRecentShare(4));
		return "index";
	}
	
	/**
	 * 文章专栏
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="article",method=RequestMethod.GET)
	public String toActicleDetail(HttpServletResponse response,HttpServletRequest request){
		request.setAttribute("msgList",msgService.getMessageNew(4));
		request.setAttribute("articleList", articleService.getArticleNew(8));
		return "article";
	}
	
	/**
	 * 资源分享
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="res_share",method=RequestMethod.GET)
	public String toResShare(HttpServletResponse response,HttpServletRequest request){
		return "res_share";
	}
	
	/**
	 * 时光轴
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="time_line",method=RequestMethod.GET)
	public String toTimeLine(HttpServletResponse response,HttpServletRequest request){
		return "time_line";
	}
	
	/**
	 * 跳转关于本站
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="about",method=RequestMethod.GET)
	public String toAbout(HttpServletResponse response,HttpServletRequest request){
		return "about";
	}
	
	/**
	 * 文章详情
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public String toDetail(HttpServletResponse response,HttpServletRequest request){
		return "detail";
	}
	
}
