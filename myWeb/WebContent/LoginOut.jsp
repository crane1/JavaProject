<%@page import="com.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserInfo user =	(UserInfo)session.getAttribute("user");
	if(user != null){
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	
%>
