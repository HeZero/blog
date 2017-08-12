var paramsMap={};
var url='/admin/article/pagination';
getData(url,paramsMap);
	var add="/admin/article/add";
	$(document).ready(function(){
		$("#add").click(function(){
			open('添加文章',add);
		});
		$("#search").click(function(){
			getData(url,$("#form").serialize());
		})
	})
function edit(id){
		var edit='/admin/article/edit/'+id;
		open('编辑文章',edit);
	}