<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>倩倩</title>
</head>
<body>
	<%
	
	
	%>
	<form action="<%=request.getContextPath() %>/MyFirstServlet" method="post">
		用户名：<input type="text" id="user" name="user" value=""><br>
		密码：<input type="password" id="pwd" name="pwd" value=""><br>
		<input type="submit" value="登录">
	</form>
	<a href="<%=request.getContextPath() %>/first.jsp">sub/sub</a>
</body>
</html>