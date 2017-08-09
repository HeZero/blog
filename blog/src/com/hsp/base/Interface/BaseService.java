package com.hsp.base.Interface;

import java.util.List;

import com.hsp.core.HMap;
import com.hsp.core.PageHelper;
/**
 * 通用接口
 * @author hsp
 *
 * @param <T>
 */
public interface BaseService<T> {
	
	/**
	 * 通过参数获取对象集合
	 * @param params
	 * @return
	 */
	List<T> getValueByParams(HMap params);
	/**
	 * 通过参数获取集合中对象数量
	 * @param params
	 * @return
	 */
	int getValueCountByParams(HMap params);
	
	/**
	 * 通过id获取对象
	 * @param id
	 * @return
	 */
	T getValueById(String id);
	/**
	 * 更新对象
	 * @param t
	 */
	void updateValueInfo(T t);
	/**
	 * 添加对象
	 * @param t
	 */
	void addValueInfo(T t);
	/**
	 * 物理删除对象
	 * @param id
	 */
	void deleteValueById(String id);
	/**
	 * 分页查询	
	 * @param page
	 */
	void selectValueInfoPagination(PageHelper page);
}
