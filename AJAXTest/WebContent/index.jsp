<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX请求</title>
<script type="text/javascript">
	var xmlHttp;
	function createAJAXObject(){
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}else{
			xmlHttp = new XMLHttpRequest();
		}
		
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var clock = document.getElementById("clock")
				clock.innerText = xmlHttp.responseText;
				var r = getColor();
				var g = getColor();
				var b = getColor();
				var color = "rgb("+r + "," + g + "," + b + ")"
				var bgColor = "rgb("+(255-r) + "," + (255-g) + "," + (255-b) + ")"
				clock.style.color =color;
				clock.style.backgroundColor = bgColor;
			}
		}
		
		xmlHttp.open("GET","server.jsp");
		xmlHttp.send(null);
	}
	
	window.onload = function(){
		setInterval("createAJAXObject()",1000);
	}
	
	function getColor(){
		return Math.floor(Math.random()*255);
	}
</script>

<style>
	#clock{
		text-align: center;
		width: 200px;
		height: 150px;
		margin: 0 auto;
	}
	h1{
		text-align:center;
	}
</style>
</head>
<body>
	<h1>多变时钟</h1>
	<div id="clock" >我是时钟</div>
</body>
</html>