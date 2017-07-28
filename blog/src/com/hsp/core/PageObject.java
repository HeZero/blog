package com.hsp.core;

import java.util.List;

public class PageObject<T> {

	private String code;
	
	private List<T> list;
	
	private String count;
	
	private String msg;
	
	private HMap map=new HMap();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HMap getMap() {
		this.map.put("list",this.getList());
		this.map.put("code", this.getCode());
		this.map.put("count", this.getCount());
		this.map.put("msg", this.getMsg());
		return map;
	}

	public void setMap(HMap map) {
		this.map = map;
	}
	
}
