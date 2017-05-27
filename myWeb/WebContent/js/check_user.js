var tools = {};
tools.$=function(id){
	return document.getElementById(id);
}
var xmlHttp;
if(window.ActiveXObject){
	xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
}else{
	xmlHttp = new XMLHttpRequest();
}

function checkUser(){
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var promt = tools.$("id_promt");
			var check = tools.$("check_img")
			promt.style.display = "inline"
			check.style.display = "none";
			
			alert(xmlHttp.responseText)
			if(xmlHttp.responseText == "0"){
				promt.innerText = "用户名可使用"
				promt.style.color = "white";
			}else if(xmlHttp.responseText == "1"){
				promt.innerText = "用户名已存在!!!"
				promt.style.color = "red";
			}else if(xmlHttp.responseText == "2"){
				promt.innerText = "用户名不能为空!!!"
				promt.style.color = "red";
			}
		}
	}
	username = tools.$("id").value;
	xmlHttp.open("GET", "CheckUser?username="+username)
	xmlHttp.send(null);
}

window.onload = function(){
	var id = tools.$("id");
	var pwd = tools.$("pwd");
	var id_promt = tools.$("id_promt");
	var pwd_promt = tools.$("pwd_promt");
	var subt = tools.$("submit")
	
	var check = tools.$("check_img");
	var img = tools.$("check");
	
	//获取焦点
	id.onfocus = function(){
		check.style.display = "inline";
		id_promt.style.display = "none"
	}
	
	pwd.onfocus = function(){
		pwd_promt.style.display = "none"
	}
	
	img.onclick = function(){
		checkUser();
	}
	
	subt.onclick = function(){
		var flag = true;
		if(id.value == null || id.value == ""){
			id_promt.style.display = "inline";
			check.style.display = "none";
			flag = false;
		}
		
		if(pwd.value == null || pwd.value == ""){
			pwd_promt.style.display = "inline";
			flag = false;
		}
		
		return flag;
	}
}



