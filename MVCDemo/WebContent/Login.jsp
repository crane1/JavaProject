<%@page import="com.study.mvc.model.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytld.tld" prefix="b" %>
<!DOCTYPE html>
<html>

	<head>
       
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录-小白的一生</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/Login.css" />
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#submit").click(function(){
					$.post("LoginServlet",
							{
								id:$("#id").val(),
								pwd:$("#pwd").val()
							},
							function(data){
								if(data == "登录成功"){
									location.href = "GetStudentsServlet";
								}else{
									$("#erro").text(data);
								}
							}
					);
				})
			})
		
		</script>
	</head>

	<body>
	<c:if test="${not empty sessionScope.user }">
		<jsp:forward page="welcomeJson.jsp"></jsp:forward>
	</c:if>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
    	<h1>欢迎来到小白的一生</h1>
		<div id="main">
			<form action="" method="post">
				<div id="outer">
					<div id="head">登录</div>
					<div class="block"><input type="text" id="id" name="id" placeholder="用户名" id="input"></div>
					<div class="block"><input type="password" id="pwd" name="pwd" placeholder="密码" id="input"></div>
					<div class="block"><input type="checkbox" class="inline"><label class="inline">下次自动登录</label></div>
					<div class="block"><input type="button" id="submit" value="登录"></div>
					<div class="block" id="erro"></div>
				</div>
			</form>
		</div>
		<b:lz key="李泽明"/>
	</body>
</html>