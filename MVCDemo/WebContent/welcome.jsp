<%@page import="java.util.List"%>
<%@page import="com.study.mvc.tools.DBUtil"%>
<%@page import="com.study.mvc.model.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link rel="stylesheet" href="css/bg.css" />
<link rel="stylesheet" href="css/Login.css" />

<style type="text/css">
	table{
		border-collapse: collapse;
		border:2px solid gray;
		margin:0 auto;
	}
	td{
		border:1px solid gray;
		padding:4px;
	}
	
	caption{
		font-size: 200%;
	}
	h1{
		text-align: center;
	}
	
	#info,#findCondition{
		float: left;
		position:relative;
		left:400px;
		margin: 10px;
	}
	
</style>
</head>
<body>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
	<%
		
		String mes = request.getParameter("mes");
		String action = request.getParameter("action");
	%>
	<c:if test="${empty sessionScope.user }">
		<jsp:forward page="LoginServlet"></jsp:forward>
	</c:if>
	<c:if test="${not empty paramScope.mes}">
		<c:choose>
			<c:when test="${paramScope.mes eq '1'}">
				<c:out value="数据更新成功"></c:out>
			</c:when>
			<c:otherwise>
				<c:out value="数据更新失败"></c:out>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	
	<h1>${sessionScope.user.s_name },终于等到你！！！</h1>
	
	<div id="findCondition">
		<h3>检索条件</h3>
		<form action="FindStuServlet" method="post">
			学号：<input type="text" name="id" /><br><br />
			姓名：<input type="text" name="name" /><br /><br />
			性别：<select name="sex">
						<option value=""></option>
						<option value="男">男</option>
						<option value="女">女</option>
				</select><br /><br />
			年龄：<input type="number" name="startAge" value="0" style="width:30px" />
			 --<input type="number" name="endAge" value="100" style="width:30px" /><br /><br />
			毕业院校：<select name="gradInst">
					<option value=""></option>
					<option value="西安工业大学">西安工业大学</option>
					<option value="西安科技大学">西安科技大学</option>
					<option value="西安皇家工业学院">西安皇家工业学院</option>
					<option value="西安草滩皇家工业学院">西安草滩皇家工业学院</option>
			   </select><br /><br />
			<input type="submit" value="查询"/>
		</form>
		
		
	</div>
	
	<div id="info">
	<table>
		<caption>学生信息</caption>
		<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan="2">操作</td></tr>
		<c:choose>
			<c:when test="${empty sessionScope.userlist }">
				<tr><td colspan='8'>暂无数据</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="stu" items="${sessionScope.userlist }" varStatus="iid">
					<tr>
						<td>${iid.index+1}</td>
						<td>${stu.s_id}</td>
						<td>${stu.s_name}</td>
						<td>${stu.s_sex}</td>
						<td>${stu.s_age}</td>
						<td>${stu.s_gradInst}</td>
						<td><a href='ModifyStuServlet?id=${stu.s_id}'>修改</a></td>
						<td><a href='UpdateServlet?action=stu_del&id=${stu.s_id}'>删除</a></td></tr>
				
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
</body>
</html>