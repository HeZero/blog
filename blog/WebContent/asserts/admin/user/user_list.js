var url="/admin/user/pagination";
var deleteUrl="/admin/user/delete";
var freezeUrl="/admin/user/freeze";
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
});

function freezeUser(userId,status){
	var str='';
	if(status=='0'){
		str="确认冻结？";
	}else if(status=='1'){
		str="确认解除？";
	}else{
		alert("状态错误!");
		return false;
	}	
	if(confirm(str)){
		$.ajax({
			url:freezeUrl+"/"+userId,
			type:'GET',
			dataType:'json',
			success:function(data){
				alert(data.msg);
				getData(url,$("#form").serialize());
			}
		});
	}
}

function deleteUser(userId){
	if(confirm("确定删除？")){
		$.ajax({
			url:deleteUrl+"/"+userId,
			type:'POST',
			dataType:'json',
			success:function(data){
				alert(data.msg);
				getData(url,$("#form").serialize());
			}
		})
	}
}

function authorization(userId){
		open('用户授权','/admin/user/edit/'+userId);
	}