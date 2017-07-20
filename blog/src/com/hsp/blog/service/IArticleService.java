package com.hsp.blog.service;

import java.util.List;

import com.hsp.base.Interface.BaseService;
import com.hsp.blog.pojo.Article;

public interface IArticleService extends BaseService<Article>{
	
	/**
	 * 查询最新的8篇文章
	 * @return
	 */
	List<Article> getArticleNew();

}
