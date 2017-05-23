var tools = {}

tools.$ = function(id){
	return document.getElementById(id);
}

function check_empty(){
	var user_id = tools.$("userid").value;
	var pwd = tools.$("pwd").value;
	
	if(!user_id.match(/^\d+$/)){
		alert("用户ID必须是数字！！！")
		return false;
	}
	
	if(user_id == null || user_id == ""){
		alert("用户ID不能为空！！！")
		return false;
	}
	
	if(pwd == null || pwd == ""){
		alert("密码不能为空！！！")
		return false;
	}
	
	return true;
}
