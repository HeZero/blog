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
</style>
</head>
<body>
	<div style="margin: 15px;">
		<form>
			<input type="text" class="layui-input search-w"  name="name" />
			<input type="button"  class="layui-btn layui-btn-normal dis-l" value="搜索"/>
			<input type="button" id="add" class="search-f-r layui-btn layui-btn-normal " value="新增"/>
		</form>
		<table id="dataTable" class="site-table table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" id="selected-all"></th>
					<th>文章标题</th>
					<th>文章内容</th>
					<th>文章类别</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<!--内容容器-->
			<tbody id="con">
				<tr>
					<td><input type="checkbox"></td>
					<td>Layui</td>
					<td>Beginner</td>
					<td>2016-11-16 11:50</td>
					<td><a href="/detail-1" target="_blank"
						class="layui-btn layui-btn-normal layui-btn-mini">预览</a> <a
						href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a>
						<a href="javascript:;" data-id="1" data-opt="del"
						class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>
				</tr>
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
				<td>{{ item.articleType }}</td>
				<td>{{ item.createtime }}</td>
				<td>
					<a href="/detail-1" target="_blank" class="layui-btn layui-btn-normal layui-btn-mini">预览</a>
					<a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a>
					<a href="javascript:;" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
			{{# }); }}
	</script>
</body>
<%@include file="../common/BaseScript.jsp"%>
<script src="../../asserts/admin/message/list.js"></script>
</html>