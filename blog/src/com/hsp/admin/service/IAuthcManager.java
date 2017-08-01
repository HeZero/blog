package com.hsp.admin.service;

import java.util.HashMap;

public interface IAuthcManager {

	/**
	 * 获取权限配置
	 * @return
	 */
	HashMap<String,String> getAuthcConfig();
}
