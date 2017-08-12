var url="/admin/message/pagination";
var paramsMap={};
getData(url,paramsMap);
var add = "/admin/message/add";
$(document).ready(function() {
	$("#add").click(function() {
		open('添加消息',add);
	});
	$("#search").click(function(){
		getData(url,$("#form").serialize());
	})
})
function edit(id){
		var edit='/admin/message/edit/'+id;
		open('编辑文章',edit);
	}