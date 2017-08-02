var url="/admin/user/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/user/add";
$(document).ready(function() {
	$("#add").click(function() {
		window.location.href = add;
	});
	$("#search").click(function(){
		getData(url,$("#form").serialize());
	})
})
