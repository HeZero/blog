package com.hsp.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.base.utils.FastJsonUtils;

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
}
