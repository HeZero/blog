package com.hsp.base.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlReWriteFilter implements Filter{
	
	private List<String> avoidList;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String url=httpRequest.getServletPath();
		if(url.endsWith(".js")){
			String baseUrl="http://"+httpRequest.getServerName()+":"+httpRequest.getServerPort();
		String[] list=url.split("/asserts/");
			if(list.length>=2){
				url=baseUrl+"/asserts/"+list[1];
				
			}
		}
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
