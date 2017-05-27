<%@page import="com.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
UserInfo user = (UserInfo)session.getAttribute("user");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传头像</title>
<link rel="stylesheet" href="<%=path %>/css/bg.css" />
</head>

<body>
	<div id="layer1">
		<img src="<%=path %>/img/bg.jpg" width="100%" height="100%" />
	</div>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="pic"/>
		<input type="submit" value="上传" />
	</form>
</body>
</html>