<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.bean.UserInfo" scope="session"></jsp:useBean>
	
	<jsp:setProperty property="id" name="user" value="111004109"/>
	<jsp:setProperty property="name" name="user" value="lizeming"/>
	id:<jsp:getProperty property="id" name="user"/><br>
	name:<jsp:getProperty property="name" name="user"/><br>
	
	<form action="userbean_file.jsp" method="post">
		id:<input type="text" id="id" name="id"><br>
		name:<input type="text" id="name" name="name"><br>
		love:<input type="checkbox" name="chk" value="1">Read<br>
		<input type="checkbox" name="chk" value="2">Swim<br>
		<input type="checkbox" name="chk" value="3">Run<br>
		<input type="submit" value="submit">
	</form>
	<a href="userbean_file.jsp">跳转</a>
</body>
</html>