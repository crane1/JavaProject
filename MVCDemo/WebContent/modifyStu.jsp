<%@page import="com.study.mvc.model.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改学生信息</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/Login.css" />
		<style type="text/css">
			table{
				margin: 0 auto;
			}
		</style>
		<c:if test="${empty sessionScope.user }">
			<jsp:forward page="LoginServlet"></jsp:forward>
		</c:if>
	</head>

	<body>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
    	<form action="UpdateServlet?action=stu_upd" method="post">
    	<table>
    		<caption>修改学生信息</caption>
			<tr><td>学号：</td><td>${requestScope.stu.s_id}<input type="text" name="id" value="${requestScope.stu.s_id}" hidden="hidden" /></td></tr>
			<tr><td>姓名：</td><td><input type="text" name="name" value="${requestScope.stu.s_name}" /></td></tr>
			<c:choose>
				<c:when test="${requestScope.stu.s_sex eq '男'}">
					<tr><td>性别：男</td><td><input type="radio" name="sex" value="男" checked="checked"/> 女<input type="radio" name="sex" value="女" /></td></tr>
				</c:when>
				<c:otherwise>
					<tr><td>性别：男</td><td><input type="radio" name="sex" value="男" /> 女<input type="radio" name="sex" value="女" checked="checked" /></td></tr>
				</c:otherwise>
			</c:choose>
			<tr><td>年龄：</td><td><input type="number" name="age" value="${requestScope.stu.s_age}"/></td></tr>
			<tr><td>毕业院校：</td><td><input type="text" name="gradInst" value="${requestScope.stu.s_gradInst}" /></td></tr>
			<tr><td colspan="2" style="text-align:center"><input type="submit" value="保存"/>
		</table>
		</form>
	</body>

</html>