<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<%@include file="../common/BaseStyle.jsp"%>
<style type="text/css">
form input{
	float:left;
	margin-bottom:10px;
}
.search-f-r{
	float:right;
}
.search-w{
	width:200px;
}
.dis-l{
	margin-left:10px;
}
form label{
 color:#2F4056;
 text-align: center;
}
</style>
</head>
<body>
	<div style="margin: 15px;">
		<form id="form">
			<label class="layui-form-label">消息名称</label>
			<input type="text" class="layui-input search-w"  name="title" />
			<input type="button" id="search" class="layui-btn layui-btn-normal dis-l" value="搜索"/>
			<input type="button" id="add" class="search-f-r layui-btn layui-btn-normal " value="新增"/>
		</form>
		<table id="dataTable" class="site-table table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" id="selected-all"></th>
					<th>消息名称</th>
					<th>消息内容</th>
					<th>消息类型</th>
					<th>相关地址</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<!--内容容器-->
			<tbody id="con">
			</tbody>
		</table>
		<!--分页容器-->
		<div id="paged"></div>

	</div>
	<!--模板容器  -->
	<script type="text/html" id="conTemp">
			{{# layui.each(d.list, function(index, item){ }}
			<tr>
				<td><input type="checkbox"></td>
				<td>{{ item.title }}</td>
				<td>{{ item.content }}</td>
				<td>{{ item.messageType }}</td>
				<td>{{ item.url }}</td>
				<td>{{ item.createTime }}</td>
				<td>
					<a href="/admin/message/edit/{{item.messageId}}" class="layui-btn layui-btn-mini">编辑</a>
					<a href="/admin/message/delete/{{item.messageId}}" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
			{{# }); }}
	</script>
</body>
<%@include file="../common/BaseScript.jsp"%>
<script src="<%=url %>/asserts/admin/message/list.js"></script>
</html>