package com.hsp.admin.mapper;

import java.util.List;

import com.hsp.admin.pojo.Authc;
import com.hsp.core.HMap;

public interface AuthcMapper {
	/**
	 * 查询平台权限设置数据
	 * @return
	 */
	List<Authc> getAuthcList();
	/**
	 * 通过参数查询
	 * @param params
	 * @return
	 */
	List<Authc> getAuthcListByParams(HMap params);
	/**
	 * 查询总数
	 * @param params
	 * @return
	 */
	int getAuthcListCountByParams(HMap params);
	/**
	 * 新增权限设置
	 * @param authc
	 */
	void addAuthc(Authc authc);
	/**
	 * 更新权限设置
	 * @param authc
	 */
	void updateAuthc(Authc authc);
}
