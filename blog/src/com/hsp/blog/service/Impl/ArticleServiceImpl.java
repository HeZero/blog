package com.hsp.blog.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.blog.mapper.ArticleMapper;
import com.hsp.blog.pojo.Article;
import com.hsp.blog.service.IArticleService;
import com.hsp.core.HMap;

@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	private ArticleMapper mapper;

	@Override
	public List<Article> getValueByParams(HMap params) {
		// TODO Auto-generated method stub
		return mapper.getArticleByParams(params);
	}

	@Override
	public Article getValueById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateValueInfo(Article t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addValueInfo(Article t) {
		t.setImgUrl("../asserts/blog/images/cover/201703181909057125.jpg");
		t.setAuthor("hsp");
		t.setIsUse("1");
		mapper.addArticle(t);
		
	}

	@Override
	public void deleteValueById(String id) {
		
	}


	@Override
	public int getValueCountByParams(HMap params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Article> getArticleNew() {
		HMap params=new HMap();
		params.put("sort", "createTime");
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("start", 0);
		params.put("size", 8);
		return mapper.getArticleByParams(params);
	}

}
