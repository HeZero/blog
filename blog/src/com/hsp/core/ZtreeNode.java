package com.hsp.core;

import java.util.List;

/**
 * zTree数据对象
 * @author hsp
 *
 */
public class ZtreeNode {

	public String id;
	
	public List<ZtreeNode> children;
	
	public String name;
	
	public boolean open;
	
	public boolean checked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ZtreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ZtreeNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
