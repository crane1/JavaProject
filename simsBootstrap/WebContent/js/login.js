var xmlhttp = "";

//检查用户名是否存在
function checkUserId() {
	if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} else {
		xmlhttp = new
		XMLHttpRequest();
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("checkuUserMsg").style.display = "block";
			if (xmlhttp.responseText == "0") {
				document.getElementById("checkuUserMsg").style.color = "red"
				document.getElementById("checkuUserMsg").innerText = "用户名不能为空";
			} else if (xmlhttp.responseText == "1") {
				document.getElementById("checkuUserMsg").style.color = "blue"
				document.getElementById("checkuUserMsg").innerText = "用户名存在";
			} else {
				document.getElementById("checkuUserMsg").style.color = "black"
				document.getElementById("checkuUserMsg").innerText = "用户名不存在";
			}
		}
	}
	var userId = document.getElementById("userId").value;
	xmlhttp.open("POST", "CheckIDServlet?userId=" + userId);
	xmlhttp.send(null);
}


//验证码输入检查
function checkImgNum(){
    if(window.ActiveXObject){
	  	xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
  	}else{
	  	xmlhttp=new XMLHttpRequest();
  	}
  	xmlhttp.onreadystatechange=function(){
	  if(xmlhttp.readyState==4&&xmlhttp.status==200){
		  document.getElementById("c_randNum").style.display="block";
		  if(xmlhttp.responseText=="NULL"){
			  document.getElementById("c_randNum").style.color="red";
			  document.getElementById("c_randNum").innerText="请输入验证码";
		  }else if(xmlhttp.responseText=="NG"){
			  document.getElementById("c_randNum").style.color="blue";
			  document.getElementById("c_randNum").innerText="验证码输入有误，请重新输入";
		  }else{
			  document.getElementById("c_randNum").style.color="green";
			  document.getElementById("c_randNum").innerText="验证码输入正确";
		  }
	  }
  }
  var randNum=document.getElementById("randNum").value;
  xmlhttp.open("GET","NumServlet?randNum="+randNum);
	  xmlhttp.send(null);
} 
  
	
//验证码图片改变
function getNewRand(){
  document.getElementById("image").src="imgServlet?randNum="+Math.random();
}

var yj={};
yj.$=function(element){
 	return document.getElementById(element);
}
yj.check=function(elementIn,elementDis){
	if(elementIn.value==null||elementIn.value==""){
		elementDis.style.display="block";
		return false;
	}else{				
		return true;
	}
}
yj.checkAll=function(){
	yj.$("c_userId").style.display="none";
	yj.$("c_password").style.display="none";
	yj.$("c_randNum").style.display="none";
	
	if((!this.check(yj.$("userId"),yj.$("c_userId")))|
	(!this.check(yj.$("pwd"),yj.$("c_password")))|
	(!this.check(yj.$("randNum"),yj.$("c_randNum")))){
		document.getElementById("c_randNum").style.color="red";
		document.getElementById("c_randNum").innerText="请输入验证码";
		return false;
	}else{	
		return true;
	}
}