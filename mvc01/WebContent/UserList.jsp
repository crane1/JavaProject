<%@page import="com.study.mvc.model.bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>具体功能页面</title>
</head>
<body>
	<%
		UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
		if(userinfo==null){
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			return;
		}
	%>
	欢迎您，${sessionScope.userInfo.name}
</body>
</html>