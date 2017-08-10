var url="/admin/user/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/user/add";
$(document).ready(function() {
	$("#add").click(function() {
		//window.location.href = add;
		layer.open({
			type:2,
			title:'添加用户',
			maxmin: true,
			content:['/admin/user/add','no'],
			area:['800px','600px']
		})
	});
	$("#search").click(function(){
		getData(url,$("#form").serialize());
	})
})
