var url="/admin/message/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/message/add";
$(document).ready(function() {
	$("#add").click(function() {
		window.location.href = add;
	})
})