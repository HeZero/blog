package com.hsp.blog.mapper;

import java.util.List;

import com.hsp.blog.pojo.Article;
import com.hsp.core.HMap;

public interface ArticleMapper {
   
	/**
	 * 添加文章
	 * @param article
	 */
   void addArticle(Article article);
   /**
    * 修改文章
    * @param article
    */
   void updateArticle(Article article);
   /**
    * 查询文章
    * @param params
    * @return
    */
   List<Article> getArticleByParams(HMap params);
   /**
    * 总数，用于分页
    * @param params
    * @return
    */
   int getArticleCountByParams(HMap params);
   
   /**
    * 通过id删除文章
    * @param articleId
    */
   void deleteValueById(String articleId);
   
}