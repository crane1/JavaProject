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
				<form action="${pageScope.path}/AdminClassServlet?action=appClLeader" method="post">
					<table>
						<tr>
							<td>
								请输入待任命的班级ID：
							</td>
							<td>
								<input type="text" id="clID" name="clID" placeholder="请输入班级ID">
							</td>
						</tr>
						<tr>
							<td>
								请输入你需要任命的班主任ID：
							</td>
							<td>
								<input type="text" id="clLeader" name="clLeader" placeholder="请输入班主任ID">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="提交">
							</td>
						</tr>
						<c:if test="${not empty requestScope.addLedMsg}">
							<tr>
								<td colspan="2">${requestScope.addLedMsg}</td>
							</tr>
						</c:if>
					</table>
				</form>
			</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>

</html>