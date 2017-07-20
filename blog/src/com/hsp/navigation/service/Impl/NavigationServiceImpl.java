package com.hsp.navigation.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.core.HMap;
import com.hsp.navigation.mapper.NavigationMapper;
import com.hsp.navigation.pojo.Navigation;
import com.hsp.navigation.service.INavigationService;

@Service("navigationServiceImpl")
public class NavigationServiceImpl implements INavigationService{

	@Autowired
	NavigationMapper navigationMapper;
	
	@Override
	public List<Navigation> getMenuTree() {
		HMap param=new HMap();
		List<Navigation> navList=navigationMapper.getNavigationList(param);
		List<Navigation> resultList =new ArrayList<Navigation>();
		for(int i=0;i<navList.size();){
			if(navList.get(i).getParentId()==0){
				resultList.add(navList.get(i));
				navList.remove(i);
			}else{
				i++;
			}
		}
		for(Navigation resultNav: resultList){
			Tree(resultNav, navList);
		}
		return resultList;
	}
	
	private void Tree(Navigation resultNav,List<Navigation> navList) {
		for(int i=0;i<navList.size();i++){
			Navigation navigation=navList.get(i);
			if(navigation.getParentId()==resultNav.getNavId()){
				if(resultNav.getChildren()==null){
					resultNav.setChildren(new ArrayList<Navigation>());
				}
				resultNav.getChildren().add(navigation);
				Tree(navigation, navList);
			}
		}
	}

}
