package com.hsp.base.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;

import com.hsp.base.utils.FastJsonUtils;
import com.hsp.core.HMap;

@Controller
public class BaseController {

	/**
	 * ajax输出json字符串方法
	 * @param response
	 * @param data
	 */
	protected void writeJsonData(HttpServletResponse response,Object data){
		response.setHeader("Access-Control-Allow-Origin", "*");  //解决跨域问题
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(FastJsonUtils.toJSONString(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 导出表格方法
	 * @param response
	 * @param excel
	 * @throws IOException
	 */
	protected void writeExcel(HttpServletResponse response,Workbook excel) throws IOException{
		response.reset();
		response.setHeader("Content-Type", "application/octet-stream");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        excel.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
	/**
	 * 分页数据获取方法
	 * @param list
	 * @param count
	 * @return
	 */
	protected Map<String,String> getPagination(List list,int count){
		HMap map=new HMap();
		map.put("list", list);
		map.put("code", 0);
		map.put("count",count);
		map.put("msg", "");
		return map;
	}
}
