var url="/admin/user/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/user/add";
$(document).ready(function() {
	$("#add").click(function() {
		//window.location.href = add;
		open('添加用户',add);
	});
	$("#search").click(function(){
		getData(url,$("#form").serialize());
	});
})
function authorization(userId){
		open('用户授权','/admin/user/edit/'+userId);
	}