<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<%@include file="../common/BaseStyle.jsp" %>
</head>
<style>
.article-w{
	width:200px;
}
</style>
<body>
	<div style="margin: 15px;">
		<!-- <span class="layui-breadcrumb">
		  <a href="/">首页</a>
		  <a href="/demo/">内容管理</a>
		  <a><cite>文章管理</cite></a>
		</span> -->

	<form class="layui-form" action="/admin/article/edit" method="POST">
				<input type="hidden" name="articleId" value="${article.articleId }">
				<div class="layui-form-item">
					<label class="layui-form-label">文章标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" value="${article.title }" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input article-w">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">文章分类</label>
					<div class="layui-input-block">
						<input type="checkbox" name="articleType" <c:if test="${article.articleType eq '0' }">checked</c:if> value="0" title="web前端">
						<input type="checkbox" name="articleType" <c:if test="${article.articleType eq '1' }">checked</c:if>  value="1" title="java" >
						<input type="checkbox" name="articleType" <c:if test="${article.articleType eq '2' }">checked</c:if>  value="2" title="大数据">
					</div>
				</div>
				
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">文章内容</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor">${article.content }</textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>	
		</div>
</body>
<%@include file="../common/BaseScript.jsp" %>
<script type="text/javascript">
	layui.use(['form', 'layedit', 'laydate'], function() {
		var form = layui.form(),
			layer = layui.layer,
			layedit = layui.layedit,
			laydate = layui.laydate;
	
		//创建一个编辑器
		var editIndex = layedit.build('LAY_demo_editor');
		//自定义验证规则
		form.verify({
			title: function(value) {
				if(value.length < 5) {
					return '标题至少得5个字符啊';
				}
			},
			pass: [/(.+){6,12}$/, '密码必须6到12位'],
			content: function(value) {
				layedit.sync(editIndex);
			}
		});
	
		//监听提交
		form.on('submit(demo1)', function(data) {
			layer.alert(JSON.stringify(data.field), {
				title: '最终的提交信息'
			})
			//return false;
		});
	});
</script>
</html>