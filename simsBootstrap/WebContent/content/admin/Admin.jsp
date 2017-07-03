<%@page import="com.sims.mvc.model.service.StudentServiceImp"%>
<%@page import="com.sims.mvc.model.service.IStudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="stylesheet" href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/main.css" />
		<script src="${pageScope.path}/js/main.js"></script>
	</head>
	
	<body>
		<div id="layer1" >
    		<img src="${pageScope.path}/img/bg.jpg" width="100%" height="100%"/>
    	</div>
		<div id="outer">
			<div id="logo" class="div_b show">学生信息管理系统</div>
			<!--主导航页面-->
			<div id="main_navig" class="div_b">
				<ul class="main_navig">
					<jsp:include page="../user_right.jsp"></jsp:include>
				</ul>
			</div>
			<div id="inner_navig" class="div_b">
				<ul>
					<li class="inner_navig"><a href="${pageScope.path}/AdminClassServlet?action=classAll">查询所有班级</a></li>
					<li class="inner_navig"><a href="${pageScope.path}/content/admin/CreateClass.jsp">创建新班级</a></li>
					<li class="inner_navig"><a href="${pageScope.path}/content/admin/appClassLeader.jsp">任命班主任</a></li>
				</ul>
			</div>
			<div id="show_info">
				<form action="${pageScope.path}/AdminClassServlet?action=classByID" method="post">
					<table border="3" style="text-align: center;width: 1000px">
						<tr>
							<td colspan="2" width="400px">请输入你想要查询的班级号：</td>
							<td colspan="3" width="600px"><input type="text" id="classID" name="classID" placeholder="请输入班级号" style="width: 400px"></td>
						</tr>
						<tr>
							<td width="200px">班级ID</td>
							<td width="200px">班级名</td>
							<td width="200px">班长</td>
							<td width="200px">班主任</td>
							<td width="200px">代课老师</td>
						</tr>
						<c:if test="${not empty requestScope.clAll}">
							<c:forEach items="${requestScope.clAll}" var="cl" >
								<tr>
									<td>${cl.id}</td>
									<td>${cl.name}</td>
									<td>${cl.monitorID}</td>
									<td>${cl.manTeacherID}</td>
									<td>${cl.teacTeacherID}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${not empty requestScope.classMes}">
							<tr>
								<td colspan="5">${requestScope.classMes}</td>
							</tr>
						</c:if>
						<tr>
							<td colspan="5">
								<input type="submit" value="查询">
								<input type="reset" value="重置">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>
</html>