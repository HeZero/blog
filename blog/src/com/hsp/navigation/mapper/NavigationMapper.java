package com.hsp.navigation.mapper;

import java.util.List;

import com.hsp.core.HMap;
import com.hsp.navigation.pojo.Navigation;

public interface NavigationMapper {

	/**
	 * 查询所有菜单
	 * @param params
	 * @return
	 */
    List<Navigation> getNavigationList(HMap params);
    

}