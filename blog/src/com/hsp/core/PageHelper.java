package com.hsp.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hsp.base.utils.FastJsonUtils;

public class PageHelper<T> {

	private int pageIndex = 1; // 页码 从1开始
	private int pageSize = 10; // 分页大小 默认10
	private List<T> list = new ArrayList<T>(); // 分页数据
	private String sort; // 排序字段
	private String order; // 排序方法 asc 或desc
	private HMap params = new HMap();// 查询参数
	private int conut;// 符合查询条件的总条目数

	public PageHelper() {

	}

	public PageHelper(HttpServletRequest request) {
		
		
		HMap params = new HMap(request);
		this.pageIndex = params.getInt("pageIndex", 1);	//获取页码
		this.pageSize = params.getInt("pageSize", 10); //获取分页大小
		this.sort = params.getString("sort"); //获取排序
		this.order = params.getString("order");
		generatePaginationParam();
		Iterator iter = params.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			//System.out.println(key);
			Object val = params.get(key);
			if(val.toString().trim().equals("")){
				params.put(key, null);
			}
		}
		this.params = params;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {

		return FastJsonUtils.toJSONString(this); // 直接转为json输出
	}

	public HMap getParams() {
		return params;
	}

	public void setParams(HMap params) {
		this.params = params;
	}

	public int getConut() {
		return conut;
	}

	public void setConut(int conut) {
		this.conut = conut;
	}

	public void generatePaginationParam() {
		params.put("pageIndex", (pageIndex - 1) * pageSize);
		params.put("pageSize", pageSize);
		params.put("sort", sort);
		params.put("order", order);
		
		if(null!=params.getString("isPagination")&&params.getString("isPagination").equals("false")){
			params.put("isPagination", false);
		}
		else
			params.put("isPagination", true);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public HMap getMapData(){
		HMap map=new HMap();
		map.put("list", this.list);
		map.put("code", 0);
		map.put("count",this.conut);
		map.put("msg", "");
		return map;
	}
	
	
}
