package com.hsp.blog.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.blog.mapper.ArticleMapper;
import com.hsp.blog.pojo.Article;
import com.hsp.blog.service.IArticleService;
import com.hsp.core.HMap;
import com.hsp.core.PageHelper;

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
		HMap params=new HMap();
		params.put("articleId", id);
		List<Article> list=mapper.getArticleByParams(params);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void updateValueInfo(Article t) {
		mapper.updateArticle(t);
		
	}

	@Override
	public void addValueInfo(Article t) {
		t.setImgUrl("../asserts/blog/images/cover/201703181909057125.jpg");
		t.setAuthor("hsp");
		t.setIsUse("1");
		t.setIsShare("0");
		mapper.addArticle(t);
		
	}

	@Override
	public void deleteValueById(String id) {
		mapper.deleteValueById(id);
	}


	@Override
	public int getValueCountByParams(HMap params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Article> getArticleNew(int size) {
		HMap params=new HMap();
		params.put("sort", "create_time");
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("pageIndex", 0);
		params.put("pageSize", size);
		return mapper.getArticleByParams(params);
	}

	@Override
	public List<Article> getArticleHot(int size) {
		HMap params=new HMap();
		params.put("sort", "hot_sort");
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("pageIndex", 0);
		params.put("pageSize", size);
		return mapper.getArticleByParams(params);
	}

	@Override
	public List<Article> getArticleSort(int size, String field) {
		HMap params=new HMap();
		params.put("sort", field);
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("pageIndex", 0);
		params.put("pageSize", size);
		return mapper.getArticleByParams(params);
	}

	@Override
	public List<Article> getRecentShare(int size) {
		HMap params=new HMap();
		params.put("sort", "create_time");
		params.put("isShare", "1");
		params.put("order", "ASC");
		params.put("isPagination", true);
		params.put("pageIndex", 0);
		params.put("pageSize", size);
		return mapper.getArticleByParams(params);
	}

	@Override
	public void selectValueInfoPagination(PageHelper page) {
		page.getParams().put("isPagination", true);
		page.generatePaginationParam();
		page.setList(mapper.getArticleByParams(page.getParams()));
		page.setConut(mapper.getArticleCountByParams(page.getParams()));
	}

}
