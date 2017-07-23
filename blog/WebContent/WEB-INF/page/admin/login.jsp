<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>烟雨楼后台登录</title>
		<link rel="stylesheet" href="../asserts/admin/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="../asserts/admin/css/login.css" />
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1>迷离烟雨中</h1>
			</header>
			<div class="beg-login-main">
				<form id="form" action="/admin/login" class="layui-form" method="post"><input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" name="username" value="hsp" lay-verify="username" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" name="password" value="111111" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div class="beg-pull-left beg-login-remember">
							<label>记住帐号？</label>
							<input type="checkbox" name="rememberMe" value="true" lay-skin="switch" checked title="记住帐号">
						</div>
						<div class="beg-pull-right">
							<button id="login" class="layui-btn layui-btn-primary" lay-submit lay-filter="login">
                            <i class="layui-icon">&#xe650;</i> 登录
                        </button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p>Beginner © www.mistory.com</p>
			</footer>
		</div>
		<script src="../asserts/js/jquery.js"></script>
		<script>
			   layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
				form.on('submit(login)',function(data){
				})
			});    
			  /*  $(document).ready(function(){
				$("#login").click(function(){
					$.ajax({
						url:'/admin/login',
						type:'POST',
						data:$("#form").serialize(),
						dataType:'json',
						success:function(data){
							alert(data.msg);
							window.location.href='/admin/index';
							return false;
						}
					})
				})
			})    */
		</script>
	</body>

</html>