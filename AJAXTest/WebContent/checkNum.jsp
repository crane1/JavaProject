<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>验证码</title>
        <script type="text/javascript">
        	function checkNum(){
        		var xmlHttp;
        		
        		if(window.ActiveXObject){
        			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")
        		}else{
        			xmlHttp = new XMLHttpRequest();
        		}
        		xmlHttp.onreadystatechange = function(){
        			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
        				document.getElementById("mes").style.color = "red";
        				if(xmlHttp.responseText == "0"){
        					document.getElementById("mes").innerText = "请输入验证码";
        				}else if(xmlHttp.responseText == "1"){
        					document.getElementById("mes").innerText = "后台未生成验证码，请刷新页面";
        				}else if(xmlHttp.responseText == "2"){
        					document.getElementById("mes").style.color = "green";
        					document.getElementById("mes").innerText = "验证码验证通过";
        				}else if(xmlHttp.responseText == "3"){
        					document.getElementById("mes").innerText = "验证码输入有误";
        				}
        			}
        		}
        		var rand = document.getElementById("rand").value;
        		xmlHttp.open("GET", "CheckNumServlet?rand=" + rand);
        		xmlHttp.send(null);
        	}
        	
        	function changeNum(){
        		document.getElementById("img").src = "CreateNumServlet?rand=" + Math.random();
        	}
        </script>
        
        <style type="text/css">
        	#img{
        		vertical-align: middle;
        	}
        </style>
    </head>
    <body>
    	验证码：<input type="text" id="rand" name="rand" />
    	<img src="CreateNumServlet" id="img" onclick="changeNum()" />
    	<button type="button" onclick="checkNum()">检查验证码</button>
    	<div id="mes"></div>
 	</body>
</html>