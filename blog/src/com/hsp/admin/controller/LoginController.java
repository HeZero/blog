package com.hsp.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.admin.pojo.User;
import com.hsp.admin.service.IUserService;
import com.hsp.base.controller.BaseController;

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
	
	/**
	 * 后台登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		return "/admin/login";
	}
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param rememberme
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,boolean rememberMe,
			@ModelAttribute("User")User user){
		/*HMap result=new HMap();
		try {
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
			Subject currentUser=SecurityUtils.getSubject();
			//判断是否已经登陆
			if(!currentUser.isAuthenticated()){
				if(rememberMe){
					token.setRememberMe(true);				
				}
				currentUser.login(token);
			}
			result.put("msg", "登陆成功!");
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			result.put("msg", "账号不存在!");
		} catch (LockedAccountException e){
			e.printStackTrace();
			result.put("msg", "账号被锁定!");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			result.put("msg", "密码错误!");
		}finally{
			writeJsonData(response, result);
		}*/
		
		try {
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
			Subject currentUser=SecurityUtils.getSubject();
			//判断是否已经登陆
			if(!currentUser.isAuthenticated()){
				if(rememberMe){
					token.setRememberMe(true);				
				}
				currentUser.login(token);
			}
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "failed");
			return "/admin/login";
		}
		return "/admin/index";
	}
	
	/**
	 * 注销
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response){
		SecurityUtils.getSubject().logout();
		return "/admin/login";
	}
}
