package com.hsp.core.shiro.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hsp.admin.service.IAuthcManager;

public class SimpleFilterChainDefinitionsService extends AbstractFilterChainDefinitionsService {

	@Autowired
	IAuthcManager authcManager;
	
	 @Override  
	    public Map<String, String> initOtherPermission() {   
	        return authcManager.getAuthcConfig();  
	    }  
}
