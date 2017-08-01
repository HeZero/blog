package com.hsp.base.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtils extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1988818402996201399L;
	private String filePath; // 文件存放目录
	private String tempPath; // 临时文件目录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		filePath = this.getServletContext().getRealPath("/upload");
		tempPath = this.getServletContext().getRealPath("/tmp");
		
		try {
			DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			// threshold 极限、临界值
			diskFactory.setSizeThreshold(4 * 1024);
			// repository 临时文件目录
			diskFactory.setRepository(new File(tempPath));

			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			// 设置允许上传的最大文件大小 4M
			upload.setSizeMax(4 * 1024 * 1024);
			// 解析HTTP请求消息头
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem item : fileItems) {
				//判断是否为表单的元素字段
				if (item.isFormField()) {
					processFormField(item, pw);
				} else {
					processUploadFile(item, pw);
				}
			}// end while()

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 处理表单内容
	private void processFormField(FileItem item, PrintWriter pw)
			throws Exception {
		String name = item.getFieldName();
		String value = item.getString();
		pw.println(name + " : " + value + "\r\n");
	}

	// 处理上传的文件
	private void processUploadFile(FileItem item, PrintWriter pw)
			throws Exception {
		// 此时的文件名包含了完整的路径，得注意加工一下
		String filename = item.getName();
		System.out.println("完整的文件名：" + filename);
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());

		long fileSize = item.getSize();

		if ("".equals(filename) && fileSize == 0) {
			System.out.println("文件名为空 ...");
			return;
		}

		File uploadFile = new File(filePath + "/" + filename);
		item.write(uploadFile);
		pw.println(filename + " 文件保存完毕 ...");
		pw.println("文件大小为 ：" + fileSize + "\r\n");
	}

}
