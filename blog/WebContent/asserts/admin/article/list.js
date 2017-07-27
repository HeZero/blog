var paramsMap={};
var url='/admin/article/pagination';
getData(url,paramsMap);
	var add="/admin/article/add";
	$(document).ready(function(){
		$("#add").click(function(){
			window.location.href=add;
		});
		$("#search").click(function(){
			getData(url,{author:'hsp',title:'测试文章1'});
		})
	})