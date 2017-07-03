<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收参数</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="user" class="com.bean.UserInfo" scope="session"></jsp:useBean>
	id2:<jsp:getProperty property="id" name="user"/><br>
	name2:<jsp:getProperty property="name" name="user"/><br><br>
	
	<h3>param传值</h3>
	id:${param.id lt 3}	<br>
	name:${param.name gt 3 }	<br><br>
	
	Love1:${paramValues.chk[0]}<br>
	Love2:${paramValues.chk[1]}<br>
	Love3:${paramValues.chk[2]}<br>
</body>
</html>