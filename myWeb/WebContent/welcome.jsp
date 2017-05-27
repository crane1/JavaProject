<%@page import="com.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserInfo user = (UserInfo)session.getAttribute("user");
		String url = null;
		if(user != null){
			String name = user.getName();
			int qx = user.getQx();
			url = "vip/vip" + qx + "/Welcome.jsp?name=" + name;
		}else{
			url = "/Login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	%>
</body>
</html>