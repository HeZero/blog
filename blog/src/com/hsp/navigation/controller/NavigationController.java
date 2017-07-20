package com.hsp.navigation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.base.Exception.DataNotFoundException;
import com.hsp.base.controller.BaseController;
import com.hsp.navigation.pojo.Navigation;
import com.hsp.navigation.service.INavigationService;

@Controller
@RequestMapping(value="/admin/")
public class NavigationController extends BaseController{
	
	@Autowired
	INavigationService navigationService;
	
	/**
	 * ajax 获取动态菜单数据
	 * @param response
	 * @param request
	 * @throws DataNotFoundException 
	 */
	@RequestMapping(value="/menu/get",method=RequestMethod.GET)
	public void getMenu(HttpServletResponse response,HttpServletRequest request) {
		List<Navigation> menuData=navigationService.getMenuTree();
		writeJsonData(response, menuData);
	}

}
