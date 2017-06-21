<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
       <link rel="stylesheet" href="css/bg.css" />
	   <link rel="stylesheet" href="css/login.css" />
	   <script src="js/login.js"></script>
</head>
<body style="text-align: center;">
		
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
	<form action="updateServlet?action=insert_stu" method="post">
		<table border="1" style="margin: 30px auto;text-align: center;">
			<caption>
			         <h1>注册新学员</h1>
			</caption>
			<tr>
				<td>用户名:</td><td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<td>密码:</td><td><input type="password" id="pwd" name="pwd"></td>
			</tr>	
			<tr>
				<td>姓名:</td><td><input type="text" id="name" name="name" ></td>
			</tr>
			<tr>
				<td>性别:</td><td>男<input type="radio" id="sex" name="sex" value="男">女<input type="radio" id="sex" name="sex" value="女"></td>
			</tr>	
			<tr>
				<td>年龄:</td><td><input type="number" id="age" name="age"></td>
			</tr>
			<tr>
				<td>毕业院校:</td><td><input type="text" id="gradFrom" name="gradFrom"></td>
			</tr>	
			<tr>
				<td>电话号码:</td><td><input type="number" id="tel" name="tel"></td>
			</tr>	
			<tr>
				<td>地址:</td><td><input type="text" id="addr" name="addr"></td>
			</tr>	
			<tr>
				<td>身份证:</td><td><input type="text" id="idCard" name="idCard"></td>
			</tr>	
			<tr>
				<td>邮箱:</td><td><input type="text" id="email" name="email"></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
					<input type="reset" value=重置>
				</td>
			</tr>
			<c:if test="${not empty requestScope.registErr}">
					<tr>
						<td colspan="2"><div id="Err" style="color: red;">${requestScope.registErr}</div></td>
						
					</tr>
				</c:if>
		</table>
		
	</form>
</body>
</html>