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
import com.hsp.blog.pojo.Article;
import com.hsp.blog.service.IArticleService;
import com.hsp.core.HMap;

@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController extends BaseController {

	@Autowired
	IArticleService articleService;

	/**
	 * 跳转添加文章
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toArticleAdd(HttpServletRequest request, HttpServletResponse response) {
		return "admin/article/add";
	}

	/**
	 * 添加文章
	 * 
	 * @param request
	 * @param response
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addArticle(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("article") Article article) {
		articleService.addValueInfo(article);
		return "admin/article/list";
	}

	/**
	 * 跳转文章列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toArticleList(HttpServletRequest request, HttpServletResponse response) {
		return "admin/article/list";
	}

	/**
	 * 文章列表数据查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pagination", method = RequestMethod.POST)
	public void selectArticleList(HttpServletRequest request, HttpServletResponse response) {
		HMap params=new HMap(request);
		List<Article> articleList=articleService.getValueByParams(params);
		params.put("list", articleList);
		params.put("code", 0);
		params.put("count", "57");
		params.put("msg", "");
		writeJsonData(response, params);
	}
	/**
	 * 删除文章
	 * @param articleId
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/delete/{articleId}",method=RequestMethod.GET)
	public String delete(@PathVariable("articleId")String articleId,HttpServletRequest request,HttpServletResponse respone){
		articleService.deleteValueById(articleId);
		return "redirect:/list";
	}

	/**
	 * 跳转文章修改
	 * @param articleId
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/edit/{articleId}",method=RequestMethod.GET)
	public String toEdit(@PathVariable("articleId")String articleId,HttpServletRequest request,HttpServletResponse respone){
		Article article=articleService.getValueById(articleId);
		request.setAttribute("article", article);
		return "/admin/article/edit";
	}
	/**
	 * 修改文章
	 * @param article
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute("article")Article article,HttpServletRequest request,HttpServletResponse response){
		articleService.updateValueInfo(article);
		return "/admin/article/list";
	}
}
