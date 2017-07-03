<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>	
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="stylesheet"href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet"href="${pageScope.path}/css/main.css" />
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
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/classMoniter.jsp">班信息查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/classStuInfo.jsp">班级成员查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/createTeams.jsp">创建组</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/checkTeamStudent.jsp">组信息查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/appTeamLeader.jsp">替换组长</a></li>
			</ul>
		</div>
		<div id="show_info">
			<form action="${pageScope.path}/ClassServlet?action=classQuery" method="post">
				<table border="3" style="text-align: center; width: 1000px">
					<!-- <tr>
						<td colspan="10"><input type="text" name="classid"
							id="classid" placeholder="班级ID"></td>
							ClassServlet?action=classQuery
					</tr> -->
					<tr>
						<td>班号</td>
						<td>班名称</td>
						<td>班长</td>
						<td>班主任</td>
						<td>任课老师</td>
					</tr>
					<c:if test="${not empty requestScope.classs}">
							<tr>
								<td>${classs.id}</td>
								<td>${classs.name}</td>
								<td>${classs.monitorID}</td>
								<td>${classs.manTeacherID}</td>
								<td>${classs.teacTeacherID}</td>
							</tr>
					</c:if>
					<tr>
						<td colspan="5">
							<c:if test="${empty requestScope.classs}">
		                                                                目前没有任何
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="10"><input type="submit" value="查询"></td>
					</tr>
					<c:if test="${not empty requestScope.Err}">
					<tr>
						<td colspan="4"><div id="Err" style="color: red;">${requestScope.Err}</div></td>
						<%-- <td colspan="4"><div id="msg" style="color: red">${requestScope.errmsg}</div></td> --%>
					</tr>
				</c:if>
				</table>
			</form>
		</div>
		<div id="footer" class="div_b">链接信息区</div>
	</div>

</body>
</html>