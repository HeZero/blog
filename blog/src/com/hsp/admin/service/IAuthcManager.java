package com.hsp.admin.service;

import java.util.HashMap;

import com.hsp.admin.pojo.Authc;
import com.hsp.base.Interface.BaseService;

public interface IAuthcManager extends BaseService<Authc>{

	/**
	 * 获取权限配置
	 * @return
	 */
	HashMap<String,String> getAuthcConfig();
}
