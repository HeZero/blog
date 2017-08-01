<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form class="layui-form" action="/admin/message/edit" method="POST">
				<input type="hidden" name="messageId" value="${msg.messageId }" />
				<div class="layui-form-item">
					<label class="layui-form-label">消息名称</label>
					<div class="layui-input-block">
						<input type="text" value="${msg.title }" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input article-w">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">链接地址</label>
					<div class="layui-input-block">
						<input type="text" value="${msg.url }" name="url" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input article-w">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">样式设置</label>
					<div class="layui-input-block">
						<input type="text" value="${msg.msgColor }" name="color" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input article-w">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">消息类别</label>
					<div class="layui-input-block article-w">
						<select name="interest" lay-filter="aihao">
							<option value=""></option>
							<option value="0">写作</option>
							<option value="1" selected="">阅读</option>
							<option value="2">游戏</option>
							<option value="3">音乐</option>
							<option value="4">旅行</option>
						</select>
					</div>
				</div>

				<!-- <div class="layui-form-item">
					<label class="layui-form-label">文章类别</label>
					<div class="layui-input-inline article-w">
						<select name="quiz">
							<option value="">请选择问题</option>
							<optgroup label="城市记忆">
								<option value="你工作的第一个城市">你工作的第一个城市</option>
							</optgroup>
							<optgroup label="学生时代">
								<option value="你的工号">你的工号</option>
								<option value="你最喜欢的老师">你最喜欢的老师</option>
							</optgroup>
						</select>
					</div>
				</div> -->


				<div class="layui-form-item">
					<label class="layui-form-label">消息分类</label>
					<div class="layui-input-block">
						<input type="checkbox" name="articleType" value="0" title="系统消息">
						<input type="checkbox" name="articleType" value="1" title="普通消息" checked="">
						<input type="checkbox" name="articleType" value="2" title="前台消息">
					</div>
				</div>
				
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">消息内容</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor">${msg.content }</textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即发布</button>
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