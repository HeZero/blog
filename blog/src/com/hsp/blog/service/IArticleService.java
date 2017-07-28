package com.hsp.blog.service;

import java.util.List;

import com.hsp.base.Interface.BaseService;
import com.hsp.blog.pojo.Article;

public interface IArticleService extends BaseService<Article>{
	
	/**
	 * 查询最新的8篇文章
	 * @return
	 */
	List<Article> getArticleNew(int size);
	/**
	 * 获得热门文章排名
	 * @param size
	 * @return
	 */
	List<Article> getArticleHot(int size);
	/**
	 * 按排序字段获得文章排名
	 * @param size
	 * @param field
	 * @return
	 */
	List<Article> getArticleSort(int size,String field);
	/**
	 * 获得最近分享文章
	 * @param size
	 * @return
	 */
	List<Article> getRecentShare(int size);

}
