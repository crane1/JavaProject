<%@page import="java.util.Set"%>
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
		UserInfo cur_user = (UserInfo)session.getAttribute("user");
		Set<UserInfo> set = (Set<UserInfo>)application.getAttribute("userSet");
		
		for(UserInfo user : set){
			if(user.getId() == cur_user.getId()){
				set.remove(user);
				break;
			}
		}
		
		application.setAttribute("userSet", set);
		response.sendRedirect("Login.jsp");
	%>
</body>
</html>