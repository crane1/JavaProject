<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	外部的-----------------------
	id:<s:property value="name"/>,欢迎你！！！<br/>
	name:<s:property value="name"/>,欢迎你！！！<br/>
	tel:<s:property value="tel"/>,欢迎你！！！<br/>
	age:<s:property value="age"/>,欢迎你！！！<br/>
	love:<s:property value="love"/>,欢迎你！！！<br/>
	<%
		System.out.println("外部的外部的外部的外部的");
	%>
	<s:debug/>
</body>
</html>