<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%@include file="../common/BaseStyle.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/asserts/admin/css/list.css">
</head>
<body>
	<div style="margin: 15px;">
		<form id="form">
			<label class="layui-form-label search-form">用户名</label>
			<input type="text" class="layui-input search-w"  name="username" />
			<input type="button" id="search" class="layui-btn layui-btn-normal dis-l" value="搜索"/>
			<input type="button" id="add" class="search-f-r layui-btn layui-btn-normal " value="新增"/>
		</form>
		<table id="dataTable" class="site-table table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" id="selected-all"></th>
					<th>用户名</th>
					<th>身份证号</th>
					<th>创建时间</th>
					<th>状态</th>
					<th>最后登录时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<!--内容容器-->
			<tbody id="con">
			</tbody>
		</table>
		<!--分页容器-->
		<div id="paged" style="text-align:center"></div>

	</div>
	<!--模板容器  -->
	<script type="text/html" id="conTemp">
			{{# layui.each(d.list, function(index, item){ }}
			<tr>
				<td><input type="checkbox"></td>
				<td>{{ item.username }}</td>
				<td>{{ item.cardNumber }}</td>
				<td>{{ item.createTime }}</td>
				<td>{{ item.status }}</td>
				<td>{{ item.lastLoginTime }}</td>
				<td>
					<a href="/admin/message/edit/{{item.messageId}}" class="layui-btn layui-btn-mini">编辑</a>
					<a href="/admin/message/delete/{{item.messageId}}" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
			{{# }); }}
	</script>
</body>
<%@include file="../common/BaseScript.jsp"%>
<script src="<%=request.getContextPath() %>/asserts/admin/user/list.js"></script>
</html>