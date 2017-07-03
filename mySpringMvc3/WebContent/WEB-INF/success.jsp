<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,td{
		border:1px solid gray;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	欢迎你!!!${sessionScope.userInfo.id}<br>
	<table>
		<tr><td>ID</td><td>姓名</td></tr>
	<c:forEach var="stu" items="${userList}">
		<tr><td>${stu.id}</td><td>${stu.name}</td></tr>
	</c:forEach>
	</table>
	
	
</body>
</html>