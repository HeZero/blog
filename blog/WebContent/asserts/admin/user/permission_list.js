var url="/admin/permission/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/permission/add";
$(document).ready(function() {
	$("#add").click(function() {
		window.location.href = add;
	});
	$("#search").click(function(){
		getData(url,$("#form").serialize());
	})
})
