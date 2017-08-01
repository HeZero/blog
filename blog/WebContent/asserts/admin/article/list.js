//示例代码
	layui.config({
		base : '/asserts/admin/js/'
	}).use([ 'paging', 'code' ], function() {
		layui.code();
		var $ = layui.jquery, paging = layui.paging();
		paging.init({
			url : '/admin/article/pagination', //地址
			elem : '#con', //内容容器
			params : { //发送到服务端的参数
				t : Math.random(),
				action : 'GetXxx'
			},
			tempElem : '#conTemp', //模块容器
			pageConfig : { //分页参数配置
				elem : '#paged', //分页容器
				pageSize : 3
			//分页大小
			},
			success : function() { //渲染成功的回调
			//alert('渲染成功');
			},
			fail : function(msg) { //获取数据失败的回调
			//alert('获取数据失败')
			},
			complate : function() { //完成的回调
			//alert('处理完成');
			},
		});
	});
	var add="/admin/article/add";
	$(document).ready(function(){
		$("#add").click(function(){
			window.location.href=add;
		})
	})